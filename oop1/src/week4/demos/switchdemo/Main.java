package week4.demos.switchdemo;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		demonstrateSwitchCase();
	}
	
	private static void demonstrateSwitchCase()
	{
		String[] fruits = {"apple", "banana", "orange", "pear", "pineapple"};
		Scanner input = new Scanner(System.in);
		String choice;
		choice = input.nextLine();
		switch (choice)
		{
			case "apple":
				System.out.println("Fruit is: Apple");
				break;
			case "banana":
				System.out.println("Fruit is: Banana");
				break;
			case "orange":
				System.out.println("Fruit is: Orange");
				break;
			case "pear":
				System.out.println("Fruit is: Pear");
				break;
			case "pineapple":
				System.out.println("Fruit is: Pineapple");
				break;
			default:
				System.out.println("Not a valid fruit");
				break;
		}
	}
}
