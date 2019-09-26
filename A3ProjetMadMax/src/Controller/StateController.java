package Controller;

import View.AuthForm;
import View.FilesView;
import View.MainFrame;

public class StateController {

    private static  boolean loggedIn = false;
    private static MainFrame frame;

    public static void changeState()
    {
        if(!loggedIn)
        {
            loggedIn = !loggedIn;
            frame.changeCurrentFrame(new FilesView());
        }
        else
        {
           loggedIn = !loggedIn;
           frame.changeCurrentFrame(new AuthForm());
        }
    }

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
}
