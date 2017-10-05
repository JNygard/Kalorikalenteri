package Model;

public class Food {
	
	private int id;
	private Food100g food100g;
	private int grams;
	private Meal meal;

	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Food(int id, Food100g food100g, int grams, Meal meal) {

		this.id = id;
		this.food100g = food100g;
		this.grams = grams;
		this.meal = meal;
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

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	
	
	
	
	

}
