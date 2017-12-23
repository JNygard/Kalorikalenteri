package GUIsettings;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import GUImeal.MealWindowBuilder;

public class SettingsWindow extends JFrame{
	
	//String
	private static String title = "Asetukset";

	public SettingsWindow() {
		//Build window
		super(title);
		
		/*

		SettingsWindowBuilder.buildWindow(); //Builds window
		
		this.getContentPane().add(inner);
		setSize(windowWidth,windowHeight);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Component listeners
		setMealTabListeners();
		setFoodTabListeners();
		*/
	}

}
