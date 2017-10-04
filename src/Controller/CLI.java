package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DB.AdapterFood100g;
import Model.Food;
import Model.Food100g;
import Model.Meal;
import Model.MealTime;
import Utility.Utility;

public class CLI {
	
	
	AdapterFood100g af100;
	
	//Constructor
	public CLI() {
		af100 = new AdapterFood100g();
	}
	
	public void start() {
		controlLoop();
	}
	
	
	public void controlLoop() {
		int option = 0;
		
		do {
			option = Utility.askInt("1: Add food/100g \n9: Quit \n");
			
			switch(option) {
				case 0:
					
					break;
				case 1:
					addFood100g();
					break;
			
			
			
			}
			
			
			
		}while(option!=9);
		
		
	}
	
	
	
	public void addFood100g() {
		Food100g f = new Food100g();
		String name;
		int kcal;
		
		f.setName(Utility.askString("Food: "));
		f.setKcal(Utility.askInt("Kcal: "));
		
		af100.add(f);
	}
	
	public void addFood() {
		
	}
	
	public void addMeal() {
		
	}
	
	
	public void addmealTime() {
		
	}
	
	

}
