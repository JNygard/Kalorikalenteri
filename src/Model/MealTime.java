package Model;

import java.util.Date;

public class MealTime {
	
	private int id;
	private Meal meal;
	private int hour;
	private int day_id;

	public MealTime() {
		// TODO Auto-generated constructor stub
	}

	public MealTime(int id, Meal meal, int hour, int day_id) {
		this.id = id;
		this.meal = meal;
		this.hour = hour;
		this.day_id = day_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getDay_id() {
		return day_id;
	}

	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}

	
	




	
	
	
	

}
