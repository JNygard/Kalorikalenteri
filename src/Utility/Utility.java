package Utility;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

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
			
			
		}
		
		return null;
		
	}

}
