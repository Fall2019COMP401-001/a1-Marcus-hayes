package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/* This value 'inventoryTotal' will be used to determine the length of the arrays that will be used 
		 * to store the names and prices of the inventory.
		*/
		
		int inventoryTotal = scan.nextInt();
		
		/* These arrays will store the various values that the input will provide, including the names of items in inventory,
		their prices, the number of customers that ordered a certain item, and the total orders of a certain item. */

		String[] inventoryNames = new String[inventoryTotal];
		
		double[] inventoryVals = new double[inventoryTotal];
		
		int[] orderedProduct = new int[inventoryTotal];
		
		int[] grossProduct = new int[inventoryTotal];
		
		// This for-loop will scan in and assign the values given for the inventory into the arrays created for them.
		
		for (int i = 0; i < inventoryTotal; i++) {
			
			inventoryNames[i] = scan.next();
			
			inventoryVals[i] = scan.nextDouble();
		}
		
		/* This value 'customerCount' will be used to determine the length of the arrays that will be used 
		 * to store the names of the customers, the size of their 'shopping carts', and their 'receipts', or the sum of the 
		 * quantities of items they bought multiplied by the prices of their items.
		*/
		
		int customerCount = scan.nextInt();
		
		/* These arrays will store the names of the customers, the size of their 'shopping carts', and their 'receipts', or the sum of the 
		 * quantities of items they bought multiplied by the prices of their items. */
		
		String[] customerNames = new String[customerCount];
		
		int[] customerTotalQuans = new int[customerCount];

		// This for-loop will scan the customers' names, 'shopping carts', and 'receipts'.
		
		for (int i = 0; i < customerCount; i++) {
			
			customerNames[i] = scan.next() + scan.next();
			
			customerTotalQuans[i] = scan.nextInt();
			
			/* These arrays will hold the names of the customers' items as well as
			 * the quantities of each item */
			
			int[] customerIndQuans = new int[customerTotalQuans[i]];
			
			String[] customerIndItems = new String[customerTotalQuans[i]];
			
			/* This for-loop will scan the values of the customer's items' names and quantities 
			 * into their designated arrays. */
			
			for (int j = 0; j < customerIndQuans.length; j++) {
				
				customerIndQuans[j] = scan.nextInt();
				
				customerIndItems[j] = scan.next();
			}
			
			/* This boolean array will serve as a way of determining if a customer has bought a certain item or not;
			 * it is used to avoid increasing the number of customers that have bought a specific item simply because 
			 * the name of the item occurs more than once in its 'customerIndNames' array.
			 */
			
			boolean[] boo = new boolean[customerTotalQuans[i]];
			
			/* This for-loop will compare the customer's item selection and the inventory. The conditional
			 * statement will sum the number of customers that have bought a specific item as well as the quantities of specific items
			 * that have been bought. These values will then be stored in arrays 'orderedProduct' and 'grossProduct', respectively.
			 */
			
			for (int j = 0; j < customerIndQuans.length; j++) {
				
				for (int k = 0; k < inventoryTotal; k++) {
						
					if (inventoryNames[k].equals(customerIndItems[j])) {
						
						grossProduct[k] += customerIndQuans[j];
						
							if (!boo[j]) {
								
								orderedProduct[k]++;
								
								boo[j] = true;
								
								for (int t = 0; t < customerTotalQuans[i]; t++) {
									
									if (customerIndItems[j].equals(customerIndItems[t])) {
										
										boo[t] = true;
									}
								}
							}
						
					}
					
				}
				
			}
			
			/* This for-loop resets the boolean array to its inital values to be used 
			 * for the next customer's information.
			 */
			
			for (int p = 0; p < boo.length; p++) {
				 
				boo[p] = false;
			}
			
		}
		
		scan.close();
		
		/* This for-loop will iterate through the orderedProduct array and print out the number of customers 
		 * that ordered a certain product as well as the total quantity of that same product ordered; 
		 * if not customers bought the item, this loop will print out the statement that no customers bought
		 * that certain item.
		 */
		
		for (int i = 0; i < inventoryTotal; i++) {
			
			if (orderedProduct[i] == 0) {
				
				System.out.println("No customers bought " + inventoryNames[i]);
				
			} else {
				
				System.out.println(orderedProduct[i] + " customers bought " + grossProduct[i] + " " + inventoryNames[i]);
				
			}
		}
	}
	
}