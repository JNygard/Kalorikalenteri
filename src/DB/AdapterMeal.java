package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Food;
import Model.Meal;

public class AdapterMeal {

	Connection conn;
	String TB_1 = "meal";
	
	static AdapterFood afood = new AdapterFood();
	static AdapterMealTime amealTime = new AdapterMealTime();


	public AdapterMeal() {
		conn = SQLiteConnection.dbConnector();
	}
	
	public AdapterMeal(Connection c) {
		conn = 	c;
	}
	
	
	//Get by id
	public Meal get(int id) {
		Meal f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Meal(rs.getInt(1), rs.getString(2), afood.getAll(rs.getInt(1)));
			}
			
			rs.close();
			pst.close();
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
		
	}
	//Get by name
	public Meal get(String name) {
		Meal f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE name=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Meal(rs.getInt(1), rs.getString(2), afood.getAll(rs.getInt(1)));
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
	public ArrayList<Meal> getAll() {
		ArrayList<Meal> meals = new ArrayList();
		Meal f;
		try {
			String sql = "SELECT * FROM " + TB_1;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Meal(rs.getInt(1), rs.getString(2), afood.getAll(rs.getInt(1)));
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
	public Meal add(Meal f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (name) "
					+ " VALUES (?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			
			
			pst.execute();
			pst.close();
			
			return  getLatestEntry();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Get latest insert 
	public Meal getLatestEntry() {
		Meal f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=(SELECT MAX(ID) FROM "+ TB_1 +")";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Food> foods=null;
			if(afood.getAll(rs.getInt(1))!=null) {
				foods =  afood.getAll(rs.getInt(1));
			}
			
			while(rs.next()) {
				f = new Meal(rs.getInt(1), rs.getString(2), foods);
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
	public void update(Meal f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET name=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setInt(2, f.getId());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete
	public int delete(int id) {
		try {
			int count = amealTime.checkMealUse(id);
			if(amealTime.checkMealUse(id)>0) {
				return count;
			}
			afood.deleteByMeal(id);
			
			String sql = "DELETE FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			pst.execute();
			pst.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
