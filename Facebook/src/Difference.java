import java.util.ArrayList;
import java.util.HashSet;

public class Difference 
{

	public static int diffPossible(ArrayList<Integer> a, int b) 
	{
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for (Integer i : a)
		{
			Integer temporary = i + new Integer(b);
			if (hashSet.contains(i))
			{
				return 1;
			}
			hashSet.add(temporary);
		}
	    
	    return 0;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		a.add(5);
		
		int b = 4;
		
		System.out.println(diffPossible(a, b));
		
	}
	
}
