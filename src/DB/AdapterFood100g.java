package DB;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Food100g;

public class AdapterFood100g {
	
	
	Connection conn;
	String TB_1 = "food100g";

	public AdapterFood100g() {
		conn = SQLiteConnection.dbConnector();
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
