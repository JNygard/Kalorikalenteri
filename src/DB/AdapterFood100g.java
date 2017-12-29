package DB;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import Model.Food100g;

public class AdapterFood100g {
	
	
	Connection conn;
	String TB_1 = "food100g";

	static AdapterFood afood = new AdapterFood();
	
	public AdapterFood100g() {
		conn = SQLiteConnection.dbConnector();
	}
	
	public AdapterFood100g(Connection c) {
		conn = c;
	}
	
	//Get by id
	public Food100g get(int id) {
		Food100g f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Food100g(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
	public Food100g get(String name) {
		Food100g f = null;
		try {
			String sql = "SELECT * FROM " + TB_1 + " WHERE name=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Food100g(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
	public ArrayList<Food100g> getAll() {
		ArrayList<Food100g> foods = new ArrayList();
		Food100g f;
		try {
			String sql = "SELECT * FROM " + TB_1;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				f = new Food100g(rs.getInt(1), rs.getString(2), rs.getInt(3));
				foods.add(f);
			}
			
			rs.close();
			pst.close();
			Collections.sort(foods);
			return foods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	//Get all sstirng
	public ArrayList<String> getAllString(int scope) {
		ArrayList<String> foods = new ArrayList();
		String f = "";
		try {
			String sql = "SELECT * FROM " + TB_1;
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				switch(scope) {
					case 0:
						f = rs.getString(2);
						break;
					case 1:
						f = rs.getString(2) + " | " + rs.getInt(3) + " kcal/100g";
						break;
				
				}
				
				foods.add(f);
				
			
			}
			
			rs.close();
			pst.close();
			Collections.sort(foods, String.CASE_INSENSITIVE_ORDER);
			return foods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	//Add one
	public void add(Food100g f) {
		
		try {
			String sql = "INSERT INTO " + TB_1 + " (name, kcal) "
					+ " VALUES (?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setInt(2, f.getKcal());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Update
	public void update(Food100g f) {
		
		try {
			String sql = "UPDATE " + TB_1 + " SET name=?, kcal=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, f.getName());
			pst.setInt(2, f.getKcal());
			pst.setInt(3, f.getId());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete
	public int delete(int id) {
		int count = afood.checkF100Use(id);
		if(count>0) {
			return count;
		}
		try {
			String sql = "DELETE FROM " + TB_1 + " WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			pst.execute();
			pst.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	


}
