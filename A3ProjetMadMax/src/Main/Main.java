
package Main;

import java.sql.Connection;

import Model.CADopen;
import View.AuthForm;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthForm auth = new AuthForm(500,500);
		auth.setVisible(true);
		CADopen bdd = new CADopen();
		Connection con = null;

	}

}