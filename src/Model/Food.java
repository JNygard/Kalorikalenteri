package Model;

public class Food {
	
	private int id;
	private Food100g food100g;
	private int grams;
	private int meal_id;

	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Food(int id, Food100g food100g, int grams, int meal_id) {
		this.id = id;
		this.food100g = food100g;
		this.grams = grams;
		this.meal_id = meal_id;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Food100g getFood100g() {
		return food100g;
	}

	public void setFood100g(Food100g food100g) {
		this.food100g = food100g;
	}

	public int getGrams() {
		return grams;
	}

	public void setGrams(int grams) {
		this.grams = grams;
	}




	public int getMeal_id() {
		return meal_id;
	}




	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	
	
	
	
	
	
	

}
