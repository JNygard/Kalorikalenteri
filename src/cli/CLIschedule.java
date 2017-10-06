package cli;

import DB.AdapterDay;
import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;
import DB.AdapterMealTime;
import DB.AdapterWeek;
import Model.Week;
import Utility.Utility;

public class CLIschedule {

	static AdapterDay aday = new AdapterDay();
	static AdapterWeek aweek = new AdapterWeek();
	static AdapterMealTime amt = new AdapterMealTime();
	static AdapterFood100g af100 = new AdapterFood100g();
	static AdapterFood afood = new AdapterFood();
	static AdapterMeal ameal = new AdapterMeal();
	

	
	
	
	//---------Week start------------------------------------


	//View schedule
	public static void viewWeekSchedule() {
		
		printWeekTitles();
		
	}
	
	//Create schedule
	public static void createWeekSchedule() {
		Utility.printString("-------Creating new wek schedule-------\n");
		
		String name = Utility.askString("Give title: ");
		String description = Utility.askString("Give description: ");
		
		Week w = aweek.add(new Week(0,name,description));
		
		
	}
	
	//Print weeks 
	public static void printWeekTitles() {
		Utility.printString("-----Printing week titles-----\n");
		for(Week w : aweek.getAll()) {
			Utility.printString(w.getId() + ": " + w.getName() + " \n");
		}
		
	}
	
	
	
	
	//---------Week end------------------------------------
	
	//---------Day start------------------------------------
	
	//Print day
	
	//Add day
	
	//Delete day
	
	
	
	//---------Day end------------------------------------
	
	//---------Mealtime start------------------------------------
	
	
	
	
	
	
	//---------Mealtime end------------------------------------

}
