package DB;

import java.sql.*;
import javax.swing.*;

public class SQLiteConnection {
	
	Connection conn=null;
	
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\QH900\\eclipse-workspace\\DietPlan\\dietPlan.db");
			//JOptionPane.showMessageDialog(null, "Connection succesfull");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
