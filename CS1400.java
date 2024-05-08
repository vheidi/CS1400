import java.util.InputMismatchException;
import java.util.Scanner;

public class CS1400 {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
			System.out.println("How many grocery items do you want to enter?");
			int numItems = 0;
			boolean validInput = false;
			while (!validInput) {
				try {
					numItems = scnr.nextInt();
					validInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter an integer for the number of items.");
					scnr.next(); 
				}
			}
			scnr.nextLine();
			
			String[] groceryItems = new String[numItems];
			double[] itemPrices = new double[numItems]; 
			//create array for the grocery items and their prices depending on #items

			System.out.println("Enter grocery items and their prices:");
			for (int i = 0; i < numItems; ++i) {
			    System.out.print("Item " + (i+1) + ": ");//add 1 one so initial item is 1 rather than 0
			    try {
			    	groceryItems[i] = scnr.next();//scans for the grocery item as a string
			    } catch (InputMismatchException e) {
			    	System.out.println("Invalid input. Please eneter a valid grocery store item.");
			    	scnr.nextLine();
			    	i--;
			    	continue;
			    }
			    
			    boolean validPrice = false;
			    while (!validPrice) {
			    	try {
			    		System.out.print("Price: $");
			    		itemPrices[i] = scnr.nextDouble();
			    		validPrice = true;
			    	} catch (Exception e) {
			    		System.out.println("Invalid Input. Please enter a valid price.");
			    		scnr.next(); 
			    	}
			    }
			    scnr.nextLine();
			}

			System.out.println("\nYou entered the following grocery items and prices:");
			double totalPrice = 0.00;
			
			for (int i = 0; i < numItems; ++i) {
			    System.out.println(groceryItems[i] + ": $" + String.format("%.2f",itemPrices[i]));
			    totalPrice += itemPrices[i]; 
			}

			System.out.println("\nTotal price: $" + String.format("%.2f", totalPrice));
		}
    }
}
