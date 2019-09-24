package Model;

import java.sql.*;

public class CAD {

    private static CAD INSTANCE = null;
    private String url = "jdbc:mysql:localhost:3306/projet_madmax";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private Statement statement;
    private ResultSet rs;


    public CAD() {
        this.open();
    }

    public static synchronized CAD getInstance() {
        if (CAD.INSTANCE == null) //On vérifie qu'il n'y a pas de connexion courante
        {
            CAD.INSTANCE = new CAD();
        }
        return CAD.INSTANCE;
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    private void open() {
        try {
            //Class.forName("com.mysql.jdbc.driver");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Ca marche!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getResultSize(String req_sql) {
        int size = 0;
        try {
            Statement state = this.connection.createStatement();
            ResultSet res = state.executeQuery(req_sql);
            size = res.getFetchSize();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

}
