package test;
import java.util.*;
import java.util.Scanner;

/******************************
 * 		@author M Windle	  *
 *			100913032         *
 ******************************/

public class CustomIO {
	static Scanner input = new Scanner(System.in);
	static boolean cont = true;

	public static int getPosInt(){
		int output = 0;
		do{
			try{
				output = input.nextInt();
				cont = false;
			}catch(InputMismatchException ex){
				System.out.println("Please enter a valid number");
				input.next();
			}
		}while(cont);
		
		return output;
	}
	
	public static String stringIO(){
		String output = "";
		do{
			try{
				output = input.next();
				if(output.equals("") || output.equals("\n"))
					throw new InputMismatchException();
				cont = false;
			}catch(Exception ex){
				System.out.println("Please enter a value");
				input.next();
			}
		}while(cont);
		
		return output;
	}
}
