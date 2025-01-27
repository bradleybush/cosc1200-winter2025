import java.util.Scanner;

public class MinMax
{
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter the first number");
		float first = inputScanner.nextFloat();
		System.out.println("Enter the second number");
		float second = inputScanner.nextFloat();
		System.out.println("Enter the third number");
		float third = inputScanner.nextFloat();
		
		float maxNum = Math.max(Math.max(first, second), third);
		float minNum = Math.min(Math.min(first, second), third);
		
		System.out.println("Maximum of the three numbers is " + maxNum);
		System.out.println("Minimum of the three numbers is " + minNum);
	}
}
