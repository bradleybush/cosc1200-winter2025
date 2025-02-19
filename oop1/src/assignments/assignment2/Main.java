// Author:      Bradley Bush
// Date:        18 February 2025
// Activity:    Assignment 2: Iteration and Arrays
// File:        Main.java
// Description: Performs various operations on an array of integers. The
//              purpose of this assignment is to help practice using
//              loops (for, while, do-while) and arrays in Java.

// Explanation: The bubble sort algorithm swaps each pair moving up a
// list, pushing the larger value up to the top and repeating this
// process until the array is sorted.

package assignments.assignment2;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// --------------
		// Greet the user
		// --------------
		System.out.println("\nWelcome to the array largest/smallest/sum/"
		                   + "average value program!\n");
		
		// --------------
		
		final Scanner inputScanner = new Scanner(System.in);
		
		// --------------
		// Input handling
		// --------------
		
		// Get the array size from the user with validation
		int arrSize = getArraySizeFromUser(inputScanner);
		
		// Create an array of the specified size
		int[] userArr = new int[arrSize];
		
		// Read integers from the user with validation and store them in
		// an array
		setIntArrayFromUser(userArr, inputScanner);
		
		// --------------------
		// Processing the array
		// --------------------
		
		// Display the array elements
		System.out.print("\nArray Elements: ");
		displayArrayElements(userArr);
		
		// Find the largest and smallest numbers in and sum of the array
		int elem = userArr[0];
		int userLargest = elem;
		int userSmallest = elem;
		int userSum = elem;
		for (int i = 1; i < arrSize; i++)
		{
			elem = userArr[i];
			if (elem > userLargest)
			{
				userLargest = elem;
			}
			else if (elem < userSmallest)
			{
				userSmallest = elem;
			}
			userSum += elem;
		}
		
		// Calculate the average of the numbers in the array
		double userAverage = userSum / (double) arrSize;
		
		// Display the largest number in the array
		System.out.println("Largest Number: " + userLargest);
		// Display the smallest number in the array
		System.out.println("Smallest Number: " + userSmallest);
		// Display the sum of the numbers in the array
		System.out.println("Sum: " + userSum);
		// Display the average of the numbers in the array
		System.out.println("Average: " + userAverage);
		
		// ---------------------
		// Searching and sorting
		// ---------------------
		
		// Ask the user to enter a number to search in the array and
		// display if it exists
		searchIntArrayFromUser(userArr, inputScanner);
		
		// Sort the array in ascending order
		bubbleSortIntArray(userArr);
		// Display the sorted array
		System.out.print("\nSorted Array: ");
		displayArrayElements(userArr);
		
		// ------------------------
		// Bid farewell to the user
		// ------------------------
		System.out.println("\nThanks for playing!");
	}
	
	// Returns whether a string represents a valid integer.
	private static boolean stringIsInt(final String string)
	{
		// Catch any invalid int conversions by attempting to
		// convert to an int and catching exceptions that occur by
		// doing so
		try
		{
			Integer.parseInt(string);
			// No exceptions were caught and string wasn't determined to
			// be invalid, return that the string does indeed represent
			// a valid acceptable integer
			return true;
		}
		catch (NumberFormatException e)
		{
			// NumberFormatException was caught during attempted
			// conversion to integer with parseInt(), so string does not
			// represent a valid integer
			return false;
		}
	}
	
	private static int getArraySizeFromUser(final Scanner inputScanner)
	{
		int arrSize = 0;  // Initialize to 0
		boolean validInput = false;
		while (!validInput)
		{
			// Prompt the user for the array size
			System.out.print("Enter the number of elements "
			                 + "between 1 and 20: ");
			// Attempt to get an integer from user
			if (!inputScanner.hasNextInt())
			{
				// Non-integer inputted, skip line and display message
				inputScanner.nextLine();
				System.out.println("Invalid input. Please enter a "
				                   + "whole number.");
			}
			else
			{
				// Integer inputted, read it from user
				arrSize = inputScanner.nextInt();
				// Consume the newline from input for future scanning
				inputScanner.nextLine();
				// Check range
				if ((arrSize < 1) || (arrSize > 20))
				{
					// Out of valid range, display message
					System.out.println("Invalid input. Please enter a "
					                   + "number between 1 and 20.");
				}
				else
				{
					// In valid range, end input/validation loop
					validInput = true;
				}
			}
		}
		
		return arrSize;
	}
	
	private static void setIntArrayFromUser(final int[] arr, final Scanner inputScanner)
	{
		String[] inputs;
		boolean validInput = false;
		while (!validInput)
		{
			// Prompt the user for the elements
			System.out.print("Enter element(s) separated by spaces: ");
			// Get the elements input as string array from user
			inputs = inputScanner.nextLine().split(" ");
			// Check number of inputted elements
			if (inputs.length != arr.length)
			{
				// Incorrect number of elements, display message
				System.out.println("Invalid input. Please enter " + arr.length
				                   + " element(s).");
			}
			else
			{
				// Assume input is valid until proven otherwise
				validInput = true;
				// Iterate through the element strings, attempting to
				// convert each to an integer. If an element cannot be
				// converted, consider it as invalid and end loop.
				for (int i = 0; (i < arr.length) && validInput; i++)
				{
					String input = inputs[i];
					if (!stringIsInt(input))
					{
						// Invalid element string, display message
						System.out.println("Invalid input. "
						                   + "Please enter only whole numbers "
						                   + "separated by spaces.");
						// Stop iterating on element strings and
						// continue input/validation loop
						validInput = false;
					}
					else
					{
						// Valid element string, convert to integer and
						// add to the array
						arr[i] = Integer.parseInt(input);
					}
				}
			}
		}
	}
	
	private static void searchIntArrayFromUser(final int[] arr, final Scanner inputScanner)
	{
		int numberToSearch = 0;  // Initialize to 0
		
		// Get the number to search for from the user with validation
		boolean validInput = false;
		while (!validInput)
		{
			// Prompt the user for the number to search for
			System.out.print("\nEnter a number to search: ");
			// Attempt to get an integer from user
			if (!inputScanner.hasNextInt())
			{
				// Non-integer inputted, skip line and display message
				inputScanner.nextLine();
				System.out.println("Invalid input. Please enter a "
				                   + "whole number.");
			}
			else
			{
				// Integer inputted, read it from user
				numberToSearch = inputScanner.nextInt();
				// Consume the newline from input for future scanning
				inputScanner.nextLine();
				// End input/validation loop
				validInput = true;
			}
		}
		
		boolean found = false;
		for (int i = 0; (i < arr.length) && !found; i++)
		{
			if (arr[i] == numberToSearch)
			{
				found = true;
			}
		}
		
		if (found)
		{
			System.out.println(numberToSearch + " is found in the array.");
		}
		else
		{
			System.out.println("Could not find " + numberToSearch
			                   + " in the array.");
		}
	}
	
	// Displays elements of an array separated by spaces.
	private static void displayArrayElements(final int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (i != 0)
			{
				// Separate elements with spaces
				System.out.print(" ");
			}
			System.out.print(arr[i]);
		}
		// Print newline
		System.out.println();
	}
	
	// Sorts an array in ascending order using bubble sort algorithm.
	private static void bubbleSortIntArray(final int[] arr)
	{
		int i;
		int j;
		int first;
		int second;
		boolean isSwapped = true;
		// Subtract 1 because the last element would have no further
		// elements to swap
		for (i = 0; (i < arr.length - 1) && isSwapped; i++)
		{
			isSwapped = false;
			// Subtract 1 because we are checking in pairs iterating
			// over the first of each, so the last element wouldn't form
			// a pair, and subtract i because the ending i elements are
			// already accounted for
			for (j = 0; j < (arr.length - 1 - i); j++)
			{
				// Swap the values
				first = arr[j];
				second = arr[j + 1];
				if (first > second)
				{
					arr[j] = second;
					arr[j + 1] = first;
					isSwapped = true;
				}
			}
		}
	}
}
