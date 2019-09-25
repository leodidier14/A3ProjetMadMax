package Model;

import java.sql.*;
import java.util.Properties;

public class CAD extends Properties{

    private static CAD INSTANCE = null;
    private String url = "jdbc:mysql://localhost/good?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";



    public CAD() {
        this.setUrl(url);
        this.setPassword(password);
        this.setUsername(username);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}