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
	
	//Commandline interface
	static CLI cli = new CLI();
	
	//Graphical user interface
	static MainWindow gui2 = new MainWindow();

	public Main() {
	}
	

	public static void main(String[] args) {

		//cli.start();


	}

}
