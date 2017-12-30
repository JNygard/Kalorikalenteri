package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Food100g;
import Model.Week;

public class AdapterUser {
	
	

	static Connection conn = SQLiteConnection.dbConnector();
	static String TB_1 = "user";
	
	static AdapterDay aDay = new AdapterDay();

	public AdapterUser() {
		
	}
	
	
	//Check if user has been displayed the instuctions the first time
	public static boolean instructionCheck() {
		boolean checked = false;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, 1);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(2)==1) {
					checked = true;
				}else {
					setInstructionCheck(true);
					checked = false;
				}
			}
			
			rs.close();
			pst.close();
			return checked;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;	
		}
	}
	
	
	//Set instructions to readed
	public static void setInstructionCheck(boolean b) {
		int i = 0;
		
		if(b) {
			i = 1;
		}

		try {
			String sql = "UPDATE " + TB_1 + " SET instruction=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, i);
			pst.setInt(2,1);
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
