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

}
