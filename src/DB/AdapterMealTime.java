package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.Meal;
import Model.MealTime;
import Utility.Utility;

public class AdapterMealTime {

	Connection conn;
	String TB_1 = "meal_time";
	
	AdapterMeal ameal;

	public AdapterMealTime() {
		conn = SQLiteConnection.dbConnector();
		ameal = new AdapterMeal();
	}
	
	
	//Get by id
	public MealTime get(int id) {
		MealTime f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new MealTime(rs.getInt(1),ameal.get(rs.getInt(2)), Utility.stringToDate(rs.getString(3)));
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
	public ArrayList<MealTime> getAll() {
		ArrayList<MealTime> meals = new ArrayList();
		MealTime f;
		try {
			String sql = "SELECT * FROM " + TB_1;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new MealTime(rs.getInt(1),ameal.get(rs.getInt(2)), Utility.stringToDate(rs.getString(3)));
				meals.add(f);
			}
			
			rs.close();
			pst.close();
			return meals;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	
	//Add one
	public MealTime add(MealTime f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (meal_id, time) "
					+ " VALUES (?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getMeal().getId());
			pst.setString(2, Utility.dateToString(f.getTime()));
			
			
			pst.execute();
			pst.close();
			
			return  getLatestEntry();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Get latest insert 
	public MealTime getLatestEntry() {
		MealTime f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=(SELECT MAX(ID) FROM "+ TB_1 +")";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new MealTime(rs.getInt(1),ameal.get(rs.getInt(2)), Utility.stringToDate(rs.getString(3)));
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
	public void update(MealTime f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET meal_id=?, time=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getMeal().getId());
			pst.setString(2, Utility.dateToString(f.getTime()));
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
