package Model;

public class Food {
	
	private int id;
	private int food100g_id;
	private int grams;

	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	public Food(int id, int food100g_id, int grams) {
		this.id = id;
		this.food100g_id = food100g_id;
		this.grams = grams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFood100g_id() {
		return food100g_id;
	}

	public void setFood100g_id(int food100g_id) {
		this.food100g_id = food100g_id;
	}

	public int getGrams() {
		return grams;
	}

	public void setGrams(int grams) {
		this.grams = grams;
	}
	
	

}
