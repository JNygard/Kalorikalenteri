package Model;

public class Meal {
	
	private int id;
	private String name;

	public Meal() {
		// TODO Auto-generated constructor stub
	}

	public Meal(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	

}
