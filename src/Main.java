import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.AdapterFood100g;
import DB.SQLiteConnection;
import GUI.GUI;
import GUImain.MainWindow;
import GUImeal.MealWindow;
import Model.Food100g;
import cli.CLI;

public class Main {
	
	static CLI cli = new CLI();
	//static MainWindow gui2 = new MainWindow();
	static MealWindow mw = new MealWindow();

	public Main() {
	}
	

	public static void main(String[] args) {
		
		
		cli.start();
		
		/*
		AdapterFood100g a100 = new AdapterFood100g();
		
		String s= "";
		
		
		for(Food100g f: a100.getAll()) {
			s+= f.getName() + " | ";
		}
		
		
		JOptionPane.showMessageDialog(null, s);
*/

	}

}
