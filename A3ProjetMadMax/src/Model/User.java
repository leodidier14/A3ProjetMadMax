package Model;

import java.util.ArrayList;

public class User {

    private int ID;
    private String username;
    private String password;
    private ArrayList<FilesModel> files;

    public User(String username, String password) {
        this.files = new ArrayList<FilesModel>();
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public ArrayList<FilesModel> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FilesModel> files) {
        this.files = files;
    }

    public String prepare_request()
    {
        return "SELECT ID_Users FROM users WHERE Login_Users='" + this.username + "'AND Password_Users='" + this.password +"';";
    }

    public String add_User()
    {
        return "INSERT INTO users COLUMNS";
    }


}
