package PrintableSchedule;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
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
	public static String docName;
	
	
	public ScheduleBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Build tct document
	public static void buildDocument(Week w) {
		
		PrintWriter writer;
		try {
			docName = "Resources/print/"+w.getName()+".txt"; 
			writer = new PrintWriter(docName, "UTF-8");
			
			//Print week name
			writer.println(w.getName());
			writer.println("");
			
			//Print 
			for(Day d : w.getDays()) {
				writer.println(Utility.weekDayToString(d.getDay()+7) + " (" + d.getKcals() + " Kcal)");
				writer.println("____________________________");
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
			e.printStackTrace();
		}
		
	}
	
	//Print document
	public static void printDocument() {
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printer(new File(docName)));
        boolean ok = job.printDialog();
        if (ok) {
            try {
                 job.print();
            } catch (PrinterException ex) {
             /* The job did not successfully complete */
            }
        }
	}
	

}
