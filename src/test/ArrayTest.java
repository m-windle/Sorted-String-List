package test;
import java.util.Scanner;

import array.ArrayRefSortedStringList;

/******************************
 * 		@author M Windle	  *
 *			100913032         *
 ******************************/

public class ArrayTest {	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		String testString = "";

		System.out.print("Please enter the desired list capacity: ");
		int size = CustomIO.getPosInt();
		boolean errorMessage;
		
		ArrayRefSortedStringList studentList = new ArrayRefSortedStringList(size);
		do{
			System.out.print("\nPlease chose one of the following options: \n"
					+ "(A)dd, (R)emove, (D)isplay (Enter to exit): ");
			testString = sc.nextLine();
			switch(testString.toLowerCase()){
				case "a": 
					if(!studentList.isFull()){
						System.out.print("\nPlease enter the student name: ");
						testString = sc.nextLine();
						studentList.add(testString);
					}
					else
						System.out.println("\n*List is full!*");
					break;
				case "r":
					if(studentList.size() != 0){
						System.out.print("\nPlease enter the student name: ");
						testString = sc.nextLine();
						errorMessage = studentList.remove(testString);
					}
					else{
						System.out.println("\n*The list is empty!*");
						break;
					}
					if(!errorMessage)
						System.out.println("\n*Student not found*");
					break;
				case "d":
					if(studentList.size() != 0)
						System.out.print(studentList.toString());
					else
						System.out.println("\n*The list is empty!*");
					break;
				case "":
					System.out.println("\nThanks for using Student List");
					sc.close();
					return;
				default:
					System.out.println("\nInvalid input");
			}
		}while(true);
		
	}
}
