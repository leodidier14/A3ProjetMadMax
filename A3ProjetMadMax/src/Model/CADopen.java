package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CADopen {
	
	private static CADopen INSTANCE= null;
    private String url = "jdbc:mysql://localhost/good?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";
    private Connection connection = null;
    private Statement statement;
    private ResultSet rs;
    
	public CADopen() {
		this.open();
	}
	
	public static synchronized CADopen getInstance() {
		if (CADopen.INSTANCE == null) {
			CADopen.INSTANCE = new CADopen();
		}
		return CADopen.INSTANCE;
	}
	
    
    private void open() {
        try {
            Class.forName("com.mysql.jdbc.driver");
            connection = DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword());
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


}
