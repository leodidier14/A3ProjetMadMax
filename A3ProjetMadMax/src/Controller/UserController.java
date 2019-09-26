package Controller;

import Model.CADopen;
import Model.User;

public class UserController {

    public static boolean authenticate(String username, String password) {

        System.out.println("Username : " + username + "\nPassword : " + password);

        boolean res = false;
        User user = new User(username, password);
        System.out.println(user.getUsername() + " " + user.getPassword());
        /*CADopen cad = new CADopen();
        if (cad.getResultSize(user.prepare_request()) == 1)
        {
            res = true;
            System.out.println("Connect�");
            StateController.changeState();
            //Auth valide, on enclenche le passage au second panel
        }
        else {
        	System.out.println("Utilisateur non reconnu");
        } */

        return res;
    }}
