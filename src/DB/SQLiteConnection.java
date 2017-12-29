package DB;

import java.sql.*;
import javax.swing.*;

public class SQLiteConnection {
	
	Connection conn=null;
	
	
	//This DB contains users modified data
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:Resources/dietPlan.db");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//This DB contains the program default data
	public static Connection dbConnectorDefault() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:Resources/dietPlanDefault.db");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
