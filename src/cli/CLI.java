package cli;

import java.util.ArrayList;
import java.util.Scanner;

import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;
import Model.Food;
import Model.Food100g;
import Model.Meal;
import Model.MealTime;
import Utility.Utility;

public class CLI {
	
	
	static AdapterFood100g af100= new AdapterFood100g();
	static AdapterFood afood= new AdapterFood();
	static AdapterMeal ameal= new AdapterMeal();
	

	
	public void start() {
		controlLoop();
		System.out.println("End");
	}
	
	
	//Main loop
	public void controlLoop() {
		int option = 10;
		
		do {
			Utility.printString("\n----------Menu----------------");
			option = Utility.askInt("\n"
					+ "0: Quit \n"
					+ "--------------------\n"
					+ "1: Print foods/100g/100g\n"
					+ "2: Add food\n"
					+ "3: Delete food/100g\n"
					+ "--------------------\n"
					+ "4: Print meals\n"
					+ "5: Add meal\n"
					+ "6: Delete meal\n"
					+ "--------------------\n"
					+ "7: Print week schedule\n"
					+ "8: Create new week schedule\n"
					+ ">");
			
			switch(option) {
				case 0:
					return;
				case 1:
					printFoods100g();
					break;
				case 2:
					addFood100g();
					break;
				case 3:
					deleteFood100g();
					break;
				case 4:
					printMeals();
					break;
				case 5:
					addMeal();
					break;
				case 6:
					deleteMeal();
					break;
				case 7:
					CLIschedule.viewWeekSchedule();
					break;
				case 8:
					CLIschedule.createWeekSchedule();
					break;
			
			}
		
		}while(option!=0);
		
		
	}
	
	//---------------Meal START-------------------------------------
	
	//Add meal
	private void addMeal() {
		Meal m = new Meal();
		//ArrayList<Food> foods = new ArrayList();
		
		Utility.printString("-------Creating new meal item-------\n");
		
		//Create new meal
		String name = Utility.askString("Meal name: ");
		m = new Meal(0, name);
		
		m = ameal.add(m);
		
		
		int option = 10;
		do {
			option = Utility.askInt("0: End \n"
					+ "1: Add new food item to meal \n"
					+ ">");
			switch(option){
				
				case 0:
					return;
				case 1:
					addFood(m.getId());
					break;
			}
		}while(option!=0);
		
		
	}



	//Delete meal
	private void deleteMeal() {
		
	}

	//Print meals
	public static void printMeals() {
		Utility.printString("--------Printing all meals-----------\n");
		for(Meal m : ameal.getAll()) {
			printMeal(m);
			Utility.printNL(1);
		}
		Utility.printNL(1);
	}
	
	//Print meal titles
	public static void printMealTitles() {
		Utility.printString("--------Meal titles-----------\n");
		for(Meal m : ameal.getAll()) {
			Utility.printString(m.getId() + ": " + m.getName() + "\n");
		}
		Utility.printNL(1);
	}
	
	//Print meal
	public static void printMeal(Meal m) {

		int mealKcals = 0;
		
		//Calculate meal kcals
		for(Food f : afood.getAll(m.getId())) {
			int kcals = f.getFood100g().getKcal() * f.getGrams();
			kcals = kcals/100;
			mealKcals+=kcals;
		}
		Utility.printString(m.getId() + ": " + m.getName() + "(" + mealKcals + " Kcals)" +": \n");
		
		//Print foods
		for(Food f : afood.getAll(m.getId())) {
			int kcals = f.getFood100g().getKcal() * f.getGrams();
			kcals = kcals/100;
			Utility.printString(" " + f.getGrams() + "g " +  f.getFood100g().getName() + " = " + kcals + " Kcal\n");
		}
		
		
	}
	
	//---------------Meal END-------------------------------------
	//--------------Food Start------------------------------------
	
	//Add food
	private void addFood(int mid) {
		printFoods100g();
		int f100ID = Utility.askInt("Food/100g id(from list above): ");
		int grams = Utility.askInt("Amount (g): ");
		afood.add(new Food(0,af100.get(f100ID),grams, mid));
		
	}
	
	//Delete food
	private void deleteFood() {
		
		int id = Utility.askInt("Delete food id: ");
		afood.delete(id);
		
	}
	
	//--------------Food END------------------------------------
	//--------------Food/100g START-------------------------------------
	
	//Add new food!100g
	public void addFood100g() {
		Food100g f = new Food100g();
		String name;
		int kcal;
		
		f.setName(Utility.askString("Food: "));
		f.setKcal(Utility.askInt("Kcal: "));
		
		af100.add(f);
	}
	
	//Delete food/100g
	public void deleteFood100g() {
		int id = Utility.askInt("ID: ");
		af100.delete(id);
	}
	
	//Print all
	public static void printFoods100g() {
		Utility.printString("----------Printing foods/100g----------------\n");
		for(Food100g f : af100.getAll()) {
			Utility.printString(f.getId() + ": " + f.getName() + ", " + f.getKcal() + " kcal \n");
		}
	}
	
	//--------------Food/100g END-------------------------------------
	
	

	
	

}
