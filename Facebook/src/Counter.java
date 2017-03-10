import java.util.ArrayList;
import java.util.List;

public class Counter 
{

	public static int singleNumber(final List<Integer> a) 
	{
	    
	    int result = 0;
        for (int element : a)
        {
            result ^= element;
        }
        return result;
	    
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(1);
		
		System.out.println(singleNumber(a));
		
	}
	
}
