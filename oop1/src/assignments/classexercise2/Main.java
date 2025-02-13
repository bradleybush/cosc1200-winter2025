// Author:      Bradley Bush
// Date:        12 February 2025
// Activity:    Class Exercise 2: Functions
// File:        Main.java
// Description: This In class exercise aims to help students understand
//              how to define and use methods (functions) in Java, as
//              well as differentiate between pass by value (primitives)
//              and pass by reference (objects/arrays).

// Explanation: Pass by value means that the argument being passed into
//              a function is assigned the value (primitive) copying
//              rather than mutating the value assigned to the variable
//              that is passed in. Pass by reference means that the
//              argument is assigned the value from the variable passed
//              in, that references the (object/array/etc.) value,
//              meaning that the value in the argument will also be a
//              reference and can mutate the original value that is
//              referenced by the variable that is passed in.

package assignments.classexercise2;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// --------------
		// Greet the user
		// --------------
		System.out.println("\nWelcome to the pass by value/" +
				           "pass by reference/" +
				           "function demonstration program!");
		
		// -------------
		// Pass by value
		// -------------
		// Show that value does not change for int
		System.out.println("\nPASS BY VALUE:");
		int valToIncrement = 5;
		// Print the un-incremented value
		System.out.println("Value before increment(): " + valToIncrement);
		// Increment the value by 10
		increment(valToIncrement);
		// Print the value after incrementation to show that its value did not change
		System.out.println("Value after increment(): " + valToIncrement);
		
		// -----------------
		// Pass by reference
		// -----------------
		// Show that element values do change for array
		System.out.println("\nPASS BY REFERENCE:");
		int[] arrToModify = {5, 10, 15, 20};
		// Print the unmodified array
		System.out.println("Array before modifyArray(): " + Arrays.toString(arrToModify));
		// Add 10 to each element of array
		modifyArray(arrToModify);
		// Print the array in after modification to show that its values have changed
		System.out.println("Array after modifyArray(): " + Arrays.toString(arrToModify));
		
		// ----------------------
		// Function demonstration
		// ----------------------
		// Ask the user to enter an array of size 5
		System.out.println("\nFUNCTION DEMONSTRATION:");
		System.out.println("Please enter five values to be in the array.");
		int[] userArr = new int[5];
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("First value: ");
		userArr[0] = inputScanner.nextInt();
		System.out.print("Second value: ");
		userArr[1] = inputScanner.nextInt();
		System.out.print("Third value: ");
		userArr[2] = inputScanner.nextInt();
		System.out.print("Fourth value: ");
		userArr[3] = inputScanner.nextInt();
		System.out.print("Fifth value: ");
		userArr[4] = inputScanner.nextInt();
		// Ask the user to enter two indexes to swap in the array
		System.out.println("\nPlease enter two indices to swap in the array.");
		int swapIndexFirst = getIndexFromUser("First index: ", 0, 4);
		int swapIndexSecond = getIndexFromUser("Second index: ", 0, 4);
		// Print the unmodified array
		System.out.println("Array before swapValues(): " + Arrays.toString(userArr));
		// Swap the elements at the specified indexes
		swapValues(userArr, swapIndexFirst, swapIndexSecond);
		// Print the modified array
		System.out.println("Array after swapValues(): " + Arrays.toString(userArr));
		
		// ------------------------
		// Bid farewell to the user
		// ------------------------
		System.out.println("\nThanks for playing!");
	}
	// Takes an integer, adds 10 to it, and prints the result.
	private static void increment(int num)
	{
		// Add 10 to argument
		num += 10;
		// Print the result
		System.out.println("increment() result: " + num);
	}
	// Takes an integer array, adds 10 to each element, and prints the result.
	private static void modifyArray(int[] arr)
	{
		// Add 10 to each element
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] += 10;
		}
		// Print the result
		System.out.println("modifyArray() result: " + Arrays.toString(arr));
	}
	// Takes an integer array and two indexes, and swaps the elements
	// at the given two indexes.
	private static void swapValues(int[] arr, int i, int j)
	{
		// Swap elements of arr at indexes i and j
		if (i != j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	// Takes integers min and max and String prompt, prompts the user
	// for an index input, validates it to be between given min and max,
	// and returns it.
	private static int getIndexFromUser(final String prompt, final int min, final int max)
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.print(prompt);
		int index = inputScanner.nextInt();
		while ((index < min) || (index > max))
		{
			System.out.println("Invalid index. " +
					           "Please enter an index between " +
					           min + " and " + max);
			System.out.print(prompt);
			index = inputScanner.nextInt();
		}
		return index;
	}
}
