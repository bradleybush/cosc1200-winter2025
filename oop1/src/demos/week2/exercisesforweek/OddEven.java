package demos.week2.exercisesforweek;

import java.util.Scanner;

public class OddEven
{
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = inputScanner.nextInt();
		
		if (number % 2 == 0)
		{
			// Even
			System.out.println("even");
		}
		else
		{
			// Odd
			System.out.println("odd");
		}
	}
}
