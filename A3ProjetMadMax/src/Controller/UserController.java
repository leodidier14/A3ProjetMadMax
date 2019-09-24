package Controller;

import Model.CAD;
import Model.User;

public class UserController {

    public boolean authenticate(String username, String password)
    {
        boolean res = false;
        User user = new User(username,password);

        return res;
    }
}
