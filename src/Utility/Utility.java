package Utility;

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
	
	

}
