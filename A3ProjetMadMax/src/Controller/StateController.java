package Controller;

import Model.User;
import View.AuthForm;
import View.FilesView;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class StateController {

    private static boolean loggedIn = false;
    private static User currentUser = null;
    private static MainFrame frame;


    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        StateController.loggedIn = loggedIn;
    }

    public static MainFrame getFrame() {
        return frame;
    }

    public static void setFrame(MainFrame frame) {
        StateController.frame = frame;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User CurrentUser) {
        currentUser = CurrentUser;
    }

    public static void changeState() {
        if (!loggedIn) {
            loggedIn = !loggedIn;
            frame.changeCurrentFrame(new FilesView());
        } else {
            loggedIn = !loggedIn;
            frame.changeCurrentFrame(new AuthForm());
        }
    }

    public static void updateFrame()
    {
        frame.repaint();
        frame.revalidate();
    }

    public static boolean validate(Container[] components) {
        boolean res = true;
        for (Container c : components) {
            switch (c.getClass().getName()) {

                //On pourra rajouter des cases en fonction des composants à tester

            }


        }

        return res;
    }

}
