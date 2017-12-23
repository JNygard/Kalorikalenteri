package PrintableSchedule;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import Model.Day;
import Model.Food;
import Model.MealTime;
import Model.Week;
import Utility.Utility;

public class ScheduleBuilder {
	
	
	//Content

	public ScheduleBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void buildDocument(Week w) {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(w.getName()+"-tulosta.txt", "UTF-8");
			
			//Print week name
			writer.println(w.getName());
			writer.println("");
			
			//Print 
			for(Day d : w.getDays()) {
				writer.println(Utility.weekDayToString(d.getDay()+7) + " (" + d.getKcals() + " Kcal)");
				writer.println("_____________________________________________");
				for(MealTime mt : d.getMealTimes()) {
					writer.println("Klo. " + mt.getHour() + ":00  " + mt.getMeal().getName() + " (" + mt.getMeal().getKcals() + " Kcal)");
					
					for(Food f : mt.getMeal().getFoods()) {
						writer.println(" -" + f.getFood100g().getName() + " " + f.getGrams() + " g/ml = " + Utility.calculateFoodCalories(f) + " Kcal.");
					}
					writer.println("");
				}
				writer.println("");
				
				
			}
			
			
			
			writer.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
