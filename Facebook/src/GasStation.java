import java.util.ArrayList;
import java.util.List;

public class GasStation 
{

	public static void main(String[] args)
	{
		List<Integer> gas = new ArrayList<Integer>();
		List<Integer> cost = new ArrayList<Integer>();
		gas.add(1);
		gas.add(2);
		cost.add(2);
		cost.add(1);
		
		System.out.println(canCompleteCircuit(gas, cost));
		
	}
	
	public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) 
	{
		
		int n;
	    int petrol = 0;
	    int i;
	    int min = 0;
	    int lastPos = 0;
	    
	    n = gas.size();
	    
	    for (i = 0; i < n; i++) 
	    {
	        petrol += gas.get(i);
	        petrol -= cost.get(i);

	        lastPos = Math.max(petrol, gas.get(i) - cost.get(i) + lastPos);
	        
	        if (lastPos >= 0) 
	        {
	            if (min == -1)
    	        {
	            	min = i;
    	        }
	        } 
	        else 
	        {
	            min = -1;
	        }
	        
	        lastPos = Math.max(0, lastPos);
	    }
	    
	    if (petrol < 0)
	    {
	    	return -1;
	    }
	    
	    return min;
	    
	}
	
}