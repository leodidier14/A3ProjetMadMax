package Controller;

import Model.CADopen;
import Model.User;

public class UserController {

    public static boolean authenticate(String username, String password) {

        System.out.println("Username : " + username + "\nPassword : " + password);

        boolean res = false;
        User user = new User(username, password);
        System.out.println();
        CADopen cad = new CADopen();
        if (cad.getResultSize(user.prepare_request()) == 1)
        {
            res = true;
        }

        return res;
    }
}
