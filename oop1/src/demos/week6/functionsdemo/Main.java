package demos.week6.functionsdemo;

public class Main
{
	public static void main(String[] args)
	{
		int number = 15;
		
		// Pass by value
		System.out.println("The value of number is (before): " + number);
		changeValue(number);
		System.out.println("The value of number is (after): " + number);
		
		number = 20;
		
		// Pass by reference
		NumberWrapper numberWrapper = new NumberWrapper(number);
		System.out.println("The value of number in numberWrapper is (before): " + numberWrapper.number);
		changeValue2(numberWrapper);
		System.out.println("The value of number in numberWrapper is (after): " + numberWrapper.number);
		
		Integer num = 25;
		System.out.println("The value of num in Integer is (before): " + num);
		changeValue3(num);
		System.out.println("The value of num in Integer is (after): " + num);
	}
	
	static void changeValue(int number)
	{
		number += 10;
	}
	
	static void changeValue2(NumberWrapper numberWrapper)
	{
		numberWrapper.number += 10;
	}
	
	static void changeValue3(Integer number)
	{
		number += 10;
	}
	
	static class NumberWrapper
	{
		public int number;
		public NumberWrapper(int number)
		{
			this.number = number;
		}
	}
}
