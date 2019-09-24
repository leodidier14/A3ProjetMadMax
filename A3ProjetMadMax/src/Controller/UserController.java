package Controller;

import Model.CAD;
import Model.User;

public class UserController {

    public boolean authenticate(String username, String password) {

        boolean res = false;
        User user = new User(username, password);
        CAD cad = new CAD();
        if (cad.getResultSize(user.prepare_request()) == 1)
        {
            res = true;
        }

        return res;
    }
}
