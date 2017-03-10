package ArraysAndStrings;

import java.util.Scanner;

public class adder 
{
	public static void main(String[] args)
	{
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		while (!scanner.nextLine().isEmpty())
		{
			if (scanner.hasNextInt())
				count += scanner.nextInt();
			else
				System.out.println("Input must be an integer");
			
			System.out.println(count);
			scanner.nextLine();
		}
		System.out.println("Total is: "+count);
		scanner.close();
	}	
}
