package Model;

public class Meal {
	
	private int id;
	private String name;
	private int day;

	public Meal() {
		// TODO Auto-generated constructor stub
	}

	public Meal(int id, String name, int day) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	

}
