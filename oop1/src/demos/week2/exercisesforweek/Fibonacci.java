package demos.week2.exercisesforweek;

import java.util.Scanner;

public class Fibonacci
{
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = inputScanner.nextInt();
		
		int output_num = 1;
		if (number <= 0)
		{
			output_num = 0;
		}
		else
		{
			int two_before = 0;
			int one_before = 1;
			for (int i = 1; i < number; i++)
			{
				output_num = one_before + two_before;
				two_before = one_before;
				one_before = output_num;
			}
		}
		
		System.out.println(output_num);
	}
}
