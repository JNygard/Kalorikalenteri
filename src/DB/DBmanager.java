package DB;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Food;
import Model.Food100g;
import Model.Meal;
import Model.Week;

public class DBmanager {
	
	//User DB
	private static AdapterWeek aweek = new AdapterWeek();
	private static AdapterMealTime aMT = new AdapterMealTime();
	private static AdapterMeal aM = new AdapterMeal();
	private static AdapterFood100g aF100 = new AdapterFood100g();
	private static AdapterFood aF = new AdapterFood();
	private static AdapterDay aday = new AdapterDay();
	
	//Default data DB
	private static AdapterFood100g DEFaF100 = new AdapterFood100g(SQLiteConnection.dbConnectorDefault());
	private static AdapterMeal DEFaM = new AdapterMeal(SQLiteConnection.dbConnectorDefault());
	private static AdapterFood DEFaF = new AdapterFood(SQLiteConnection.dbConnectorDefault());


	public DBmanager() {
  
	}
	


	
	//Clear tables and Set default data to DB
	public static void eraseAll() {
		
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
			
			aF100.delete(f.getId());
		}

		//Add default data
		setDedaultData();
		
	}
	
	
	//Add default data
	private static void setDedaultData() {
		
		//Set food100g
		for(Food100g f : DEFaF100.getAll()) {
			aF100.add(f);
		}
		
		//Set meal
		for(Meal m : DEFaM.getAll()) {
			Meal mn = aM.add(m);
			for(Food f : DEFaF.getAll(m.getId())) {
				f.setMeal_id(mn.getId());
				f.setFood100g(aF100.get(f.getFood100g().getName()));
				aF.add(f);
				//System.out.println("F: " + f.getFood100g().getId());
			}
		}
		
		//Set instructions to not read
		AdapterUser.setInstructionCheck(false);
		
	}
	
	
	
	
	

}
