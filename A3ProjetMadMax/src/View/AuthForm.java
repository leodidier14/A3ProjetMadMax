package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthForm extends JFrame {


    private JPanel panel = new JPanel();
    private Font lblpolice = new Font("Arial", Font.BOLD, 18);
    private Font police = new Font("Arial", Font.PLAIN, 18);
    private UserController UserController;


    public AuthForm(int width, int height) {
        super();
        this.setBounds(0, 0, width, height);
        this.setSize(width, height);
        this.setLayout(null);

        JLabel lbl_login = new JLabel("Login :");
        JLabel lbl_password = new JLabel("Password :");
        JTextField txt_login = new JTextField();
        JPasswordField txt_password = new JPasswordField();
        JButton btn_login = new JButton("Connexion");


        JButton btn_quit = new JButton("Quitter");
        Font lblpolice = new Font("Arial", Font.BOLD, 18);
        Font police = new Font("Arial", Font.PLAIN, 18);


        lbl_login.setBounds(80, 165, 80, 20);
        lbl_login.setFont(lblpolice);
        lbl_password.setBounds(80, 245, 100, 20);
        lbl_password.setFont(lblpolice);
        txt_login.setBounds(180, 160, 180, 40);
        txt_login.setFont(police);
        txt_password.setBounds(180, 240, 180, 40);
        //btn_login.setBounds(120, 340, 120, 60);
        //btn_login.setFont(police);
        btn_quit.setBounds(260, 340, 120, 60);
        btn_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController.authenticate(txt_login.getText(), String.valueOf(txt_password.getPassword()));
            }
        });
        btn_quit.setFont(police);


        this.add(lbl_login);
        this.add(lbl_password);
        this.add(txt_login);
        this.add(txt_password);
        this.add(btn_quit);
        this.add(btn_login);


    }

    public Controller.UserController getUserController() {
        return UserController;
    }

    public void setUserController(Controller.UserController userController) {
        UserController = userController;
    }
}
