// Author:      Bradley Bush
// Date:        9 March 2025
// Activity:    Assignment 3: Functions
// File:        Main.java
// Description: The purpose of this assignment is to test my
//              understanding of methods in Java, including defining
//              methods, using parameters, return types, and method
//              overloading.

package assignments.assignment3;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// --------------
		// Greet the user
		// --------------
		System.out.println("\nWelcome to the function/method testing program!\n");
		
		// --------------
		
		final Scanner inputScanner = new Scanner(System.in);
		
		// -----------------------------------
		// Question 1: Basic Method Definition
		// -----------------------------------
		final int first_val = getIntFromUser("Enter first number: ", inputScanner);
		final int second_val = getIntFromUser("Enter second number: ", inputScanner);
		final int result = calculateSum(first_val, second_val);
		System.out.println("Sum: " + result + "\n");
		
		// ------------------------------
		// Question 2: Method Overloading
		// ------------------------------
		System.out.println("Product of two numbers: " + multiply(10, 2));
		System.out.println("Product of three numbers: " + multiply(10, 2, 3));
		System.out.println();  // Line spacing
		
		// ------------------------------------------
		// Question 3: Method with an Array Parameter
		// ------------------------------------------
		final int[] arr = {12, 34, 56, 78, 90};
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Maximum value: " + findMax(arr) + "\n");
		
		// ----------------------------
		// Question 4: Recursive Method
		// ----------------------------
		System.out.print("Enter a string: ");
		final String str = inputScanner.next();
		System.out.println("Reversed string: " + reverseString(str));
		
		// ------------------------
		// Bid farewell to the user
		// ------------------------
		System.out.println("\nThanks for playing!");
	}
	
	private static int getIntFromUser(final String prompt, final Scanner inputScanner)
	{
		while (true)
		{
			// Prompt the user for the first number
			System.out.print(prompt);
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
				int ret = inputScanner.nextInt();
				// Consume the newline from input for future scanning
				inputScanner.nextLine();
				return ret;
			}
		}
	}
	
	// Takes two integers and returns their sum.
	private static int calculateSum(final int first, final int second)
	{
		return first + second;
	}
	
	// Takes two integers and returns their product.
	private static int multiply(final int first, final int second)
	{
		return first * second;
	}
	
	// Takes three integers and returns their product.
	private static int multiply(final int first, final int second, final int third)
	{
		return first * second * third;
	}
	
	// Takes an integer array and returns its largest element.
	private static int findMax(final int[] arr)
	{
		// Ensure array is not empty
		if (arr.length < 1)
		{
			throw new IllegalArgumentException("findMax: Array must contain at least one element.");
		}
		int max = arr[0];
		int elem;
		for (int i = 1; i < arr.length; i++)
		{
			elem = arr[i];
			if (elem > max)
			{
				max = elem;
			}
		}
		return max;
	}
	
	// Takes a string and returns its reversed version
	private static String reverseString(final String str)
	{
		if (str.length() <= 1)
		{
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}
}
