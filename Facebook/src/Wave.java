import java.util.ArrayList;
import java.util.Collections;

public class Wave 
{

	public static ArrayList<Integer> wave(ArrayList<Integer> a) 
	{
	    Collections.sort(a);
	    
	    for (int i = 0; i < a.size() - 1; i = i + 2)
	    {
	        Integer temp = a.get(i);
	        a.set(i, a.get(i+1));
	        a.set(i + 1, temp);
	    }
	    
	    return a; 
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a  = new ArrayList<Integer>();
		a.add(5);
		a.add(1);
		a.add(3);
		a.add(2);
		a.add(4);
		
		for (Integer i : wave(a))
		{
			System.out.println(i+" ");
		}
	}
	
}
