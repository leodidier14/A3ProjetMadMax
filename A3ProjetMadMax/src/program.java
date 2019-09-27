import View.AuthForm;

import javax.swing.*;


public class program {

    static int WIDTH = 500;
    static int HEIGHT = 500;

    public static void main(String[] args) {

        JFrame form = new JFrame();
        AuthForm auth = new AuthForm();
        form.setLayout(null);
        form.setResizable(false);
        form.setTitle("Connexion");
        form.setSize(WIDTH, HEIGHT);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.add(auth);

        form.setVisible(true);


        /*CAD BDD = new CAD();
        System.out.println(BDD.getResultSize("SELECT ID FROM users WHERE username='test'"));*/
    }
}
