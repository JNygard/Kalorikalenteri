package Model;

public class MealTime {
	
	private int id;
	private int meal_id;
	private String time;

	public MealTime() {
		// TODO Auto-generated constructor stub
	}

	public MealTime(int id, int meal_id, String time) {
		this.id = id;
		this.meal_id = meal_id;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
