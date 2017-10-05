package Model;

import java.sql.Date;

public class MealTime {
	
	private int id;
	private Meal meal;
	private Date time;

	public MealTime() {
		// TODO Auto-generated constructor stub
	}

	
	

	public MealTime(int id, Meal meal, Date time) {
		this.id = id;
		this.meal = meal;
		this.time = time;
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




	public Date getTime() {
		return time;
	}




	public void setTime(Date time) {
		this.time = time;
	}




	
	
	
	

}
