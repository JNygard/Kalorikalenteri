package Model;

public class Food100g {
	
	private int id;
	private String name;
	private int kcal;
	private int fat;
	private int protein;
	private int carbohydrate;
	private int alcohol;
	private int organic_acids;
	private int sugaralcohol;
	private int fiber;

	public Food100g() {
	}

	public Food100g(int id, String name, int kcal) {
		this.id = id;
		this.name = name;
		this.kcal = kcal;
	}

	public Food100g(int id, String name, int kcal, int fat, int protein, int carbohydrate, int alcohol,
			int organic_acids, int sugaralcohol, int fiber) {
		this.id = id;
		this.name = name;
		this.kcal = kcal;
		this.fat = fat;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
		this.alcohol = alcohol;
		this.organic_acids = organic_acids;
		this.sugaralcohol = sugaralcohol;
		this.fiber = fiber;
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

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public int getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}

	public int getOrganic_acids() {
		return organic_acids;
	}

	public void setOrganic_acids(int organic_acids) {
		this.organic_acids = organic_acids;
	}

	public int getSugaralcohol() {
		return sugaralcohol;
	}

	public void setSugaralcohol(int sugaralcohol) {
		this.sugaralcohol = sugaralcohol;
	}

	public int getFiber() {
		return fiber;
	}

	public void setFiber(int fiber) {
		this.fiber = fiber;
	}
	
	
	
	

}
