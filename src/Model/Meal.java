package Model;

import java.util.ArrayList;

public class Meal {
	
	private int id;
	private String name;
	
	private ArrayList<Food> foods;

	public Meal() {
		// TODO Auto-generated constructor stub
	}

	public Meal(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

	public Meal(int id, String name, ArrayList<Food> foods) {
		this.id = id;
		this.name = name;
		this.foods = foods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}

	public int getKcals() {
		int kcals = 0;
		int k100 = 0;
		
		for(Food f : foods) {
			k100 = f.getFood100g().getKcal() * f.getGrams();
			kcals += k100/100;
		}
		
		return kcals;
	}
	

}
