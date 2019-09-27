package Controller;

import Model.CADopen;
import Model.User;

import javax.swing.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {

    private static CADopen cad = new CADopen();

    public static boolean authenticate(String username, String password) {

        System.out.println("Username : " + username + "\nPassword : " + password);

        boolean res = false;
        User user = new User(username, password);
        System.out.println(user.getUsername() + " " + user.getPassword());
        if (cad.getResultSize(user.prepare_request()) == 1)
        {
            res = true;
            System.out.println("Connect�");
            ResultSet rs = cad.m_getRows(user.prepare_request());
            try {
                rs.next();
                user.setID(rs.getInt("ID_Users"));
                StateController.setCurrentUser(user);
                FilesController.getFilesbyOwnerID(user.getID());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Impossible de recuperer l'utilisateur courant", "Erreur", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            //Auth valide, on enclenche le passage au second panel
        }
        else {
        	System.out.println("Utilisateur non reconnu");
        }
        return res;
    }

    public static CADopen getCad() {
        return cad;
    }

    public static void setCad(CADopen cad) {
        UserController.cad = cad;
    }
}
