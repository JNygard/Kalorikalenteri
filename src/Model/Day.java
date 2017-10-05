package Model;

public class Day {
	
	private int id;
	private int day;
	private Week week;

	public Day() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Day(int id, int day, Week week) {
		this.id = id;
		this.day = day;
		this.week = week;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	

}
