package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Food;
import Model.Food100g;

public class AdapterFood {

	Connection conn;
	String TB_1 = "food";
	
	static AdapterFood100g af100 = new AdapterFood100g();
	static AdapterMeal aMeal = new AdapterMeal();

	public AdapterFood() {
		conn = SQLiteConnection.dbConnector();
	}
	
	
	//Get by id
	public Food get(int id) {
		Food f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Food(rs.getInt(1), af100.get(rs.getInt(2)), rs.getInt(3), rs.getInt(4));
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
	public ArrayList<Food> getAll(int mid) {
		ArrayList<Food> foods = new ArrayList();
		Food f;
		try {
			String sql = "";
			if(mid==0) {
				 sql = "SELECT * FROM " + TB_1;
			}else {
				sql = "SELECT * FROM " + TB_1 + " WHERE meal_id="+mid;
			}
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Food(rs.getInt(1), af100.get(rs.getInt(2)), rs.getInt(3), rs.getInt(4));
				foods.add(f);
			}
			
			rs.close();
			pst.close();
			return foods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	
	//Add one
	public void add(Food f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (food100g_id, grams, meal_id) "
					+ " VALUES (?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getFood100g().getId());
			pst.setInt(2, f.getGrams());
			pst.setInt(3, f.getMeal_id());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Update
	public void update(Food f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET food100g_id=?, grams=?, meal_id=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, f.getFood100g().getId());
			pst.setInt(2, f.getGrams());
			pst.setInt(3, f.getMeal_id());
			pst.setInt(4, f.getId());
			
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
	
	//Delete by meal ID
	public void deleteByMeal(int mealID) {
		try {
			String sql = "DELETE FROM " + TB_1 + " WHERE meal_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, mealID);
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Check how many food uses food100g
	public int checkF100Use(int id) {
		int count = 0;
		try {
			
			String sql = "";
			sql = "SELECT COUNT(*) FROM " + TB_1 + " WHERE food100g_id="+id;
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			

			count = rs.getInt(1);
			
			rs.close();
			pst.close();
			return count;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
