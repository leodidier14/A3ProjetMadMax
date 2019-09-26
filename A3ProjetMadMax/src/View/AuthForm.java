package View;

import Controller.StateController;
import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthForm extends JPanel {

    private static JPanel pan;


    public AuthForm() {

        pan = this;
        JLabel title = new JLabel("MadMaxDecrypt");
        title.setBounds(120, 30, 200, 25);
        Font font = new Font("Arial", Font.BOLD, 18);
        title.setFont(font);
        this.setLayout(null);
        this.add(title);
    	  
    	 /* ImageIcon icon = new ImageIcon("D:\\Users\\leodi\\Bureau\\A3\\Projet\\seminaire_scientifique\\logo.png");
    	  JLabel img = new JLabel(icon);
    	  panelAuth.add(img);
    	  img.setBounds(110, 70, 170, 63);*/

        //Label de login

        JLabel lbl_login = new JLabel("Username : ");
        lbl_login.setBounds(40, 150, 170, 25);
        this.add(lbl_login);

        //Zone de texte du login

        JTextField txt_login = new JTextField();
        txt_login.setBounds(110, 150, 170, 25);
        this.add(txt_login);

        JLabel lbl_password = new JLabel("Password :");
        lbl_password.setBounds(40, 190, 100, 20);
        this.add(lbl_password);

        //Password field

        JPasswordField txt_password = new JPasswordField();
        txt_password.setBounds(110, 190, 170, 25);
        this.add(txt_password);

        //Bouton login

        JButton btn_login = new JButton("Connexion");
        btn_login.setBounds(150, 230, 100, 25);
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UserController.authenticate(txt_login.getText(), String.valueOf(txt_password.getPassword()))) {
                   // StateController.changeState();
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Identifiants incorrects", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btn_login);

        //Bouton quitter

        JButton btn_quit = new JButton("Quitter");
        btn_quit.setBounds(150, 280, 100, 25);
        //btn_quit.setFont(police);
        btn_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(btn_quit);
    }

}
