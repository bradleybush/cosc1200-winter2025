package demos.week5.arraysdemo;

import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		oneDimensionalArrays();
		twoDimensionalArrays();
		sortArrays();
		searchElementInArrays(45);
	}
	
	private static void oneDimensionalArrays()
	{
		double[] grades = new double[10];
		for (int i = 0; i < grades.length; i++)
		{
			grades[i] = Math.random() * 100;
		}
		
		System.out.println("For loop starts now");
		for (int i = 0; i < grades.length; i++)
		{
			System.out.println(grades[i]);
		}
		
		System.out.println("While loop starts now");
		int i = 0;
		while (i < grades.length)
		{
			System.out.println(grades[i]);
			i += 1;
		}
	}
	
	private static void twoDimensionalArrays()
	{
		int[][] twoDArray = new int[5][3];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				twoDArray[i][j] = i * j;
			}
		}
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(twoDArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void sortArrays()
	{
		int[] unsortedArray = new int[10];
		for (int i = 0; i < unsortedArray.length; i++)
		{
			unsortedArray[i] = (int)(Math.random() * 100);
		}
		
		System.out.println("Before sorting:");
		System.out.println(Arrays.toString(unsortedArray));
		
		Arrays.sort(unsortedArray);
		
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(unsortedArray));
	}
	
	private static void searchElementInArrays(int target)
	{
		int[] array = new int[50];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 100);
		}
		System.out.println("The randomly generated array:");
		System.out.println(Arrays.toString(array));
		
		int linearIndex = -1;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == target)
			{
				linearIndex = i;
				break;
			}
		}
		System.out.println("Linear index: " + linearIndex);
		
		Arrays.sort(array);
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(array));
		
		int binaryIndex = Arrays.binarySearch(array, target);
		System.out.println("Binary index: " + binaryIndex);
	}
}
