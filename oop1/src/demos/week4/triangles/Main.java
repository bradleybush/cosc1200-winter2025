package demos.week4.triangles;

public class Main
{
	public static void main(String[] args)
	{
		displayHalfTriangle(8);
		displayFullTriangle(8);
	}
	private static void displayHalfTriangle(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (j < (n - i))
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}
	private static void displayFullTriangle(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < (n - i); j++)
			{
				System.out.print(" ");
			}
			for (int j = 0; j < ((i * 2) - 1); j++)
			{
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
