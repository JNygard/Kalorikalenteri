package Model;

import java.util.ArrayList;

public class Week {

	private int id;
	private String name;
	private String description;

	
	private ArrayList<Day> days;
	
	public Week() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Week(int id, String name, String description, ArrayList<Day> days) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.days = days;
	}
	
	



	public Week(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Day> getDays() {
		return days;
	}

	public void setDays(ArrayList<Day> days) {
		this.days = days;
	}

	
	public Day getDay(int i) {
		
		for(Day d: days){
			if(d.getDay()==i) {
				return d;
			}
		}
		
		return null;
	}
	
	public int getKcal() {
		int kcals = 0;
		
		for(Day d : this.days) {
			kcals+=d.getKcals();
		}
		
		
		return kcals;
	}

	


	
	
	
	

}
