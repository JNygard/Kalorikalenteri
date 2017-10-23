package Utility;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Model.Food;
import Model.Food100g;
import Model.Meal;
import Model.Week;

public class Utility {
	
	static Scanner scan = new Scanner(System.in);

	public Utility() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static String askString(String q) {
		String s;
		
		System.out.print(q);
		s = scan.nextLine();
		
		return s;
	}
	
	public static int askInt(String q) {
		int i;
		
		System.out.print(q);
		i = Integer.parseInt(scan.nextLine());
		
		return i;
	}
	
	public static void printNL(int times) {
		int x=0;
		while(x<times) {
			System.out.print("\n");
			x++;
		}
	}
	
	public static void printString(String s) {
		System.out.print(s);
	}
	
	public static String dateToString(Date d) {
        DateFormat ogFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String s = null;
        s = ogFormat.format(d);
        
        return s;
	}
	
	public static Date stringToDate(String s) {
        DateFormat ogFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        Date d = null;
        try {
            d = (Date) ogFormat.parse(s);
        } catch (ParseException e) {e.printStackTrace();}
        
        return d;
	}
	
	public static String dateToPresentable(Date d) {
        DateFormat ogFormat = new SimpleDateFormat("HH:mm");
        String s = null;
        s = ogFormat.format(d);
        
        return s;
	}
	
	public static String weekDayToString(int i) {
		switch(i){
			case 1:
				
				return "Monday";
			case 2:
				
				return "Tuesday";
			case 3:
				
				return "Wednesday";
			case 4:
				
				return "Thursday";
			case 5:
				
				return "Friday";
			case 6:
				
				return "Saturday";
			case 7:
				
				return "Sunday";
			case 8:
				
				return "Maanantai";
			case 9:
				
				return "Tiistai";
			case 10:
				
				return "Keskiviikko";
			case 11:
				
				return "Torstai";
			case 12:
				
				return "Perjantai";
			case 13:
				
				return "Lauantai";
			case 14:
				
				return "Sunnuntai";
			
		}
		
		return null;
		
	}
	
	public static int calculateFoodCalories(Food f) {
		int k100 =  f.getFood100g().getKcal();
		int weight =  f.getGrams();
		
		int calories = 0;
		calories = k100 * weight;
		calories = calories/100;
		
		return calories;
	}

	//Create string name list from food100g list
	public static ArrayList<String> toFood100toStringArray(ArrayList<Food> mealIncridients) {
		ArrayList<String> sl = new ArrayList();
		for(Food f : mealIncridients) {
			sl.add(f.getFood100g().getName() + " " + f.getGrams() + " g");
		}
		return sl;
	}
	
	//Create string name list from food100g list
	public static ArrayList<String> mealToStringArray(ArrayList<Meal> ml) {
		ArrayList<String> sl = new ArrayList();
		for(Meal f : ml) {
			sl.add(f.getName());
		}
		return sl;
	}

	//Create string name list from food100g list
	public static ArrayList<String> weektoStringArray(ArrayList<Week> wl) {
		ArrayList<String> sl = new ArrayList();
		for(Week f : wl) {
			sl.add(f.getName());
		}
		return sl;
	}
	
}
