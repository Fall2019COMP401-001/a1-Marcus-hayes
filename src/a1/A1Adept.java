package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int inventoryTotal = scan.nextInt();
		
		/* This value 'inventoryTotal' will be used to determine the length of the arrays that will be used 
		 * to store the names and prices of the inventory.
		*/
		
		String[] inventoryNames = new String[inventoryTotal];
		
		double[] inventoryVals = new double[inventoryTotal];
		
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
		
		double[] sums = new double[customerCount];
		
		String[] customerNames = new String[customerCount];
		
		int[] customerTotalQuans = new int[customerCount];
		
		// This for-loop will scan the customers' names, 'shopping carts', and 'receipts'.
		
		for (int i = 0; i < customerCount; i++) {
			
			customerNames[i] = scan.next() + " " + scan.next();
			
			customerTotalQuans[i] = scan.nextInt();
			
			/* These arrays will hold the names of the customers' items as well as
			 * the quantities of each item */
			
			String[] customerIndItems = new String[customerTotalQuans[i]];
			
			int[] customerIndQuans = new int[customerTotalQuans[i]];
			
			/* This for-loop will scan the values of the customer's items' names and quantities 
			 * into their designated arrays.
			 */
			
			for (int j = 0; j < customerTotalQuans[i]; j++) {
				
				customerIndQuans[j] = scan.nextInt();
				
				customerIndItems[j] = scan.next();
			}
			
			/* This for loop will compare the customer's item selection and the inventory. The conditional
			 * statement will sum the products of the item's price and the quantity that the customer bought, storing
			 * the values in a separate array labelled 'sums'.
			 */
			
			for (int j = 0; j < customerIndQuans.length; j++) {
				
				for (int k = 0; k < inventoryTotal; k++) {
					
					if (inventoryNames[k].equals(customerIndItems[j])) {
						
						sums[i] += (inventoryVals[k] * customerIndQuans[j]);
						
						
					}
					
				}
				
			}
			
		}
		
		scan.close();
		
		/*These variables will contain the maximum, minimum, and average values of all the customers' shopping lists.
		 * They are initialized with the first customer's name and total price paid for groceries. */
		
		String biggest = customerNames[0];
		
		String smallest = customerNames[0];
		
		double biggun = sums[0];
		
		double smallun = sums[0];
		
		double average = 0.0;
		
		/* This for-loop will compare each customer's total price for groceries and 
		 * store the maximum value in the variable 'biggun' and the associated 
		 * customer's name in the variable 'biggest'. */
		
		for (int i = 0; i < customerCount; i++) {
			
			if (biggun < sums[i]) {
				
				biggun = sums[i];
				
				biggest = customerNames[i];
			}
		}
		
		/* This for-loop will compare each customer's total price for groceries and 
		 * store the minimum value in the variable 'smallun' and the associated 
		 * customer's name in the variable 'smallest'. */
		
		for (int i = 0; i < customerCount; i++) {
			
			if (smallun > sums[i]) {
				
				smallun = sums[i];
				
				smallest = customerNames[i];
			}
		}
		
		/* This for-loop sums all the totals of every customer into the variable 'average'. */
		
		for (int i = 0; i < customerCount; i++) {
			
			average += sums[i];
			
			}
		
		/* Now that the variable 'average' contains the total of every customer's total price paid for groceries, 
		 * it will divide itself by the number of customers to find the average total paid per customer.
		 */
		
		average = average / customerCount;
		
		String strAverage = String.format("%.2f", average);
		
		String strBiggun = String.format("%.2f", biggun);
		
		String strSmallun = String.format("%.2f", smallun);

		
		/* These statements will print out the biggest and smallest spenders, the amount they paid, and the average
		 * amount paid per customer.
		 */
		
		System.out.println("Biggest: " + biggest + " (" + strBiggun + ")");
		
		System.out.println("Smallest: " + smallest + " (" + strSmallun + ")");
		
		System.out.println("Average: " + strAverage);
		
		}

	}
