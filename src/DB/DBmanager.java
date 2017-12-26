package DB;

import java.util.ArrayList;

import Model.Food100g;
import Model.Meal;
import Model.Week;

public class DBmanager {
	
	private static AdapterWeek aweek = new AdapterWeek();
	private AdapterMealTime aMT = new AdapterMealTime();
	private static AdapterMeal aM = new AdapterMeal();
	private static AdapterFood100g aF100 = new AdapterFood100g();
	private AdapterFood aF = new AdapterFood();
	private AdapterDay aday = new AdapterDay();

	public DBmanager() {

	}
	
	//Clear tables and Set default data to DB
	public static void setDefaultData() {
		
		ArrayList<Week> weeks = aweek.getAll();
		ArrayList<Meal> meals = aM.getAll();
		ArrayList<Food100g> foods = aF100.getAll();
		
		//Delete weeks, days and mealtimes
		for(Week w : weeks) {
			aweek.delete(w);
		}
		
		//Delete meals
		for(Meal m : meals) {
			aM.delete(m.getId());
		}
		
		//Delete food100g
		for(Food100g f : foods) {
			System.out.println("F: " + f.getId());
			aF100.delete(f.getId());
		}
		
		
		
	}

}
