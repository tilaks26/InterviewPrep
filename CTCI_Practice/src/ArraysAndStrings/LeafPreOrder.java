package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeafPreOrder 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for(int t = 0; t < testCases; t++)
		{
			int size = scanner.nextInt();
			List<Integer> input = new ArrayList<Integer>();
			for (int i = 0; i < size; i++)
			{
				input.add(Integer.parseInt(scanner.next()));
			}
			preOrder(input);
		}
		scanner.close();
	}
	
	public static void preOrder(List<Integer> arr) 
	{
		if (arr == null || arr.size() == 0)
		{
			return;
		}
		Stack<Integer> stack = new Stack<>();
		for(int n = 1, c = 0; n < arr.size(); n++, c++) 
		{
			if (arr.get(c) > arr.get(n)) 
			{
				stack.push(arr.get(c));
			} 
			else 
			{
				boolean found = false;
				while(!stack.isEmpty()) 
				{	
					if (arr.get(n) > stack.peek()) 
					{
						stack.pop();
						found = true;
					} 
					else
					{
						break;	
					}
				}
				if (found) 
				{
					System.out.print(arr.get(c)+" ");
				}
			}
		}
		System.out.print(arr.get(arr.size()-1));
	}
	
}
