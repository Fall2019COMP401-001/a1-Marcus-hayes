package a1;

import java.util.Scanner;

public class A1Novice {
	
	// Creates the Main method 
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/* This value 'count' will be used to determine the number of times the below for loop will occur
		*/
		
		int count = scan.nextInt();
		
		/* This for loop will cycle through each customer, calculate their total, then
		print their name and total before moving on to the next customer */
		
		for (int i = 0; i < count; i++) {
			
			String fname = scan.next();
			
			String lname = scan.next();
			
			int itemQuan = scan.nextInt();
			
			double sum = 0.0;
			
			/* This loop iterates through the customer's shopping cart, multiplies the quantity that the
			 * customer bought by the price of the item, then adds that value to the sum variable
			 */
			
			for (int j = 0; j < itemQuan; j++) {
				
				int quantity = scan.nextInt();
				
				String name = scan.next();
				
				double price = scan.nextDouble();
				
				
				sum += (quantity * price);
				
			}
			
			/* This segment prints out the stored value of same as well as the customer's first initial and last name
			 * 
			 */
			
			String strSum = String.format("%.2f", sum);
			
			System.out.println(fname.charAt(0) + ". " + lname + ": " + strSum);
			
		}
		
		scan.close();
	}
}