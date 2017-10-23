package Model;

import java.util.ArrayList;

public class Day {
	
	private int id;
	private int day;
	private int week_id;
	private ArrayList<MealTime> mealTimes;
	

	public Day() {
		// TODO Auto-generated constructor stub
	}


	public Day(int id, int day, ArrayList<MealTime> mealTimes) {
		this.id = id;
		this.day = day;
		this.mealTimes = mealTimes;
	}
	
	
	public Day(int id, int day, int week_id, ArrayList<MealTime> mealTimes) {
		this.id = id;
		this.day = day;
		this.week_id = week_id;
		this.mealTimes = mealTimes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public ArrayList<MealTime> getMealTimes() {
		return mealTimes;
	}


	public void setMealTimes(ArrayList<MealTime> mealTimes) {
		this.mealTimes = mealTimes;
	}


	public int getWeek_id() {
		return week_id;
	}


	public void setWeek_id(int week_id) {
		this.week_id = week_id;
	}
	
	public MealTime getMealTime(int hour) {
		MealTime mt = null;
		
		for(MealTime m : this.mealTimes) {
			if(m.getHour()==hour) {
				mt = m;
			}
		}
		
		
		return mt;
	}
	
	public int getKcals() {
		int kcals = 0;
		int k100 = 0;
		for(MealTime mt : this.mealTimes) {
			Meal m = mt.getMeal();
			
			kcals+=m.getKcals();
			
		}
		
		return kcals;
		
	}
	
	

	

	
	

}
