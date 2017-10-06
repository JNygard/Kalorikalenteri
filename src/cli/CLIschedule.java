package cli;

import java.util.ArrayList;
import java.util.Date;

import DB.AdapterDay;
import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;
import DB.AdapterMealTime;
import DB.AdapterWeek;
import Model.Day;
import Model.Meal;
import Model.MealTime;
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
		Week w = new Week();
		
		printWeekTitles();
		int weekID = Utility.askInt("\nSelect week to view: ");
		w = aweek.get(weekID);
		
		printWeekSchedule(w);
		
	}
	
	//Print weekschedule
	public static void printWeekSchedule(Week w) {
		
		for(Day d : w.getDays()) {
			printDay(d);
		}
		
		
	}
	
	
	//Create schedule
	public static void createWeekSchedule() {
		Utility.printString("-------Creating new wek schedule-------\n");
		String name = Utility.askString("Give title: ");
		String description = Utility.askString("Give description: ");
		Week w = aweek.add(new Week(0,name,description));
		
		int x = 1;
		while(x<=7) {
			createDay(w.getId(), x);
			x++;
		}
		
		
		int option = 10;
		do {
			w = aweek.get(w.getId());
			printWeekSchedule(w);
			
			option = Utility.askInt("0: End\n"
					+ "1: Add new meal to schedule");
			
			switch(option) {
			case 0:
				return;
			case 1:
				addMealtime(w);
			
			}
			
			
		}while(option!=0);
		
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
	public static void printDay(Day d) {
		
		Utility.printString("-----------------\n");
		Utility.printString(Utility.weekDayToString(d.getDay()) + " \n");
		
		
		for(MealTime mt : d.getMealTimes()) {
			printMealtime(mt);
		}
		
		
	}
	
	//Add day
	public static void createDay(int wID, int day) {
		aday.add(new Day(0,day,wID,null));
		
	}
	//Delete day
	public static void deleteDay() {
		
	}
	
	
	//---------Day end------------------------------------
	
	//---------Mealtime start------------------------------------
	
	//Add new 
	public static void addMealtime(Week w) {
		MealTime mt = null;
		
		int day = Utility.askInt("Which week day(1-7): ");
		
		CLI.printMealTitles();
		
		int mid = Utility.askInt("Select meal id: ");
		
		mt = amt.add(new MealTime(0, ameal.get(mid), new Date(), w.getDay(day).getId()));
		
		Utility.printString("Mealtime added\n");
	}
	
	//Delete
	
	//Print
	public static void printMealtime(MealTime mt) {
		Meal m = mt.getMeal();
		
		Utility.printString(Utility.dateToPresentable(mt.getTime())+ " : " + m.getName() + " \n");
		
		
		//CLI.printMeal(m);
		
	}
	
	
	
	
	//---------Mealtime end------------------------------------

}
