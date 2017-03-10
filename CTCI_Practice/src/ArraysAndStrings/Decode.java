package ArraysAndStrings;

import java.util.Scanner;
import java.util.Stack;

public class Decode 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for(int t = 0; t < testCases; t++)
		{
			String str = scanner.next();
			System.out.println(decode(str));
		}
		scanner.close();
	}
	
	public static String decode(String str)
	{
		Stack<Integer> numberStack = new Stack<Integer>();
		Stack<String> characterStack = new Stack<String>();
		
		int number = 0;
		String string = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
			{
				number = 10 * number + (str.charAt(i) - '0');
			}
			
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
			{
				string += str.charAt(i);
			}
			
			else if (str.charAt(i) == '[')
			{
				numberStack.push(number);
				number = 0;
				characterStack.push(string);
				string = "";
			}
			
			else if (str.charAt(i) == ']')
			{
				int currentNumber = numberStack.peek();
				numberStack.pop();
				String currentString = characterStack.peek();
				characterStack.pop();
				
				for (int j = 0; j < currentNumber; j++)
				{
					currentString += string;
				}
				
				string = currentString;
			}
			
		}
		return string;
	}
		
}