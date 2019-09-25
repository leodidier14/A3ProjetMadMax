package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthForm extends MainFrame {


   
    //private Font lblpolice = new Font("Arial", Font.BOLD, 18);
    //private Font police = new Font("Arial", Font.PLAIN, 18);
    private UserController UserController;
    private JPanel panelAuth = new JPanel();

    public AuthForm() {
    	this.window.setContentPane(panelAuth);
    	this.panelAuth.setLayout(null);
    	
    	 JLabel title = new JLabel("MadMaxDecrypt");
    	  Font font = new Font("Arial", Font.BOLD, 18);
    	  title.setFont(font);
    	  this.panelAuth.add(title);
    	  title.setBounds(120, 30, 200, 25);
    	  
    	  ImageIcon icon = new ImageIcon("D:\\Users\\leodi\\Bureau\\A3\\Projet\\seminaire_scientifique\\logo.png");
    	  JLabel img = new JLabel(icon);
    	  panelAuth.add(img);
    	  img.setBounds(110, 70, 170, 63);
    	  
    	  
        
    	JLabel lbl_login = new JLabel("Username : ");
        this.panelAuth.add(lbl_login);
        lbl_login.setBounds(40, 150, 170, 25);
        //lbl_login.setFont(lblpolice);
        
        JTextField txt_login = new JTextField();
        this.panelAuth.add(txt_login);
        txt_login.setBounds(110, 150, 170, 25);
        //txt_login.setFont(police);
        
        JLabel lbl_password = new JLabel("Password :");
        this.panelAuth.add(lbl_password);
        lbl_password.setBounds(40, 190, 100, 20);
        //lbl_password.setFont(lblpolice);
        
        JPasswordField txt_password = new JPasswordField();
        this.panelAuth.add(txt_password);
        txt_password.setBounds(110, 190, 170, 25);

        JButton btn_quit = new JButton("Login");
        this.panelAuth.add(btn_quit);
        btn_quit.setBounds(150, 230, 100, 25);
        //btn_quit.setFont(police);
        btn_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController.authenticate(txt_login.getText(), String.valueOf(txt_password.getPassword()));
            }
        });
        }

    public Controller.UserController getUserController() {
        return UserController;
    }

    public void setUserController(Controller.UserController userController) {
        UserController = userController;
    }
   
}
