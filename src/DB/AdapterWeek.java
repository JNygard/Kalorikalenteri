package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Day;
import Model.Meal;
import Model.Week;

public class AdapterWeek {

	Connection conn;
	String TB_1 = "week";
	
	AdapterDay aDay;

	public AdapterWeek() {
		conn = SQLiteConnection.dbConnector();
		aDay = new AdapterDay();
	}
	
	
	//Get by id
	public Week get(int id) {
		Week f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Week(rs.getInt(1), rs.getString(2), rs.getString(2),
						aDay.getAll(rs.getInt(1))
						);
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
	public ArrayList<Week> getAll() {
		ArrayList<Week> weeks = new ArrayList();
		Week f;
		try {
			String sql = "SELECT * FROM " + TB_1;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Week(rs.getInt(1), rs.getString(2), rs.getString(2),
						aDay.getAll(rs.getInt(1))
						);
				weeks.add(f);
			}
			
			rs.close();
			pst.close();
			return weeks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	
	//Add one
	public Week add(Week f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (name, description) "
					+ " VALUES (?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setString(2, f.getDescription());
			
			
			pst.execute();
			pst.close();
			
			return  getLatestEntry();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Get latest insert 
	public Week getLatestEntry() {
		Week f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=(SELECT MAX(ID) FROM "+ TB_1 +")";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				ArrayList<Day> days=null;
				
				if(aDay.getAll(rs.getInt(1))!=null){
					days = aDay.getAll(rs.getInt(1));
				}
				f = new Week(rs.getInt(1), rs.getString(2), rs.getString(2),
						days
						);
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
	public void update(Week f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET name=?, description=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setString(2, f.getDescription());
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
