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
		System.out.println("End");
	}
	
	
	public void controlLoop() {
		int option = 10;
		
		do {
			option = Utility.askInt("\n"
					+ "0: Quit \n"
					+ "1: Add food/100g\n"
					+ "2: Print foods/100g\n"
					+ "3: \n"
					+ "4: \n"
					+ "5: \n"
					+ ">");
			
			switch(option) {
				case 0:
					return;
				case 1:
					addFood100g();
					break;
				case 2:
					printFoods();
					break;
				case 3:
					
					break;
			
			}
		
		}while(option!=0);
		
		
	}
	
	
	
	//Add new
	public void addFood100g() {
		Food100g f = new Food100g();
		String name;
		int kcal;
		
		f.setName(Utility.askString("Food: "));
		f.setKcal(Utility.askInt("Kcal: "));
		
		af100.add(f);
	}
	
	//Print all
	public void printFoods() {
		for(Food100g f : af100.getAll()) {
			Utility.printString(f.getName() + ", " + f.getKcal() + " kcal \n");
		}
	}
	
	
	public void addFood() {
		
	}
	
	public void addMeal() {
		
	}
	
	
	public void addmealTime() {
		
	}
	
	

}
