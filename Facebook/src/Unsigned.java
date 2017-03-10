import java.math.BigInteger;

public class Unsigned 
{

	public static int numSetBits(long a) 
	{
	    String l = String.format("%032d", new BigInteger(Long.toBinaryString((a))));
	    
	    int ones = 0;
	    
	    for (Character c : l.toCharArray())
	    {
	    	if (c == '1')
	    	{
	    		ones++;
	    	}
	    }
	    
	    return ones;
	}
	
	public static void main(String[] args)
	{
		System.out.println(numSetBits(11));
	}
	
}
