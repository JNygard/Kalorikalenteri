package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Day;
import Model.Week;

public class AdapterDay {

	Connection conn;
	String TB_1 = "day";
	
	AdapterMealTime amt;

	public AdapterDay() {
		conn = SQLiteConnection.dbConnector();
		amt = new AdapterMealTime();
	}
	
	
	//Get by id
	public Day get(int id) {
		Day f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Day(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						amt.getAll(rs.getInt(1)));
			}
			
			rs.close();
			pst.close();
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
		
	}
	
	//Get all
	public ArrayList<Day> getAll(int wid) {
		ArrayList<Day> days = new ArrayList();
		Day f;
		try {
			String sql = "";
			if(wid==0) {
				sql = "SELECT * FROM " + TB_1;
			}else {
				sql = "SELECT * FROM " + TB_1 + " WHERE week_id="+wid;
			}
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Day(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						amt.getAll(rs.getInt(1)));
				days.add(f);
			}
			
			rs.close();
			pst.close();
			return days;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	
	//Add one
	public Day add(Day f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (day, week_id) "
					+ " VALUES (?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getDay());
			pst.setInt(2, f.getWeek_id());
			
			
			pst.execute();
			pst.close();
			
			return  getLatestEntry();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Get latest insert 
	public Day getLatestEntry() {
		Day f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=(SELECT MAX(ID) FROM "+ TB_1 +")";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Day(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						amt.getAll(rs.getInt(1)));
			}
			
			rs.close();
			pst.close();
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	//Update
	public void update(Day f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET day=?, week_id=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getDay());
			pst.setInt(2, f.getWeek_id());
			pst.setInt(3, f.getId());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete
	public void delete(int id) {
		try {
			String sql = "DELETE FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
