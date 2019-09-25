package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CADopen {
	
	private static CADopen INSTANCE= null;
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
    	CAD open = new CAD(); 
        try {
            //Class.forName("com.mysql.jdbc.driver");
            connection = DriverManager.getConnection(open.getUrl(), open.getUsername(), open.getPassword());
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
