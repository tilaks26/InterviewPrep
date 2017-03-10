
public class Power 
{

	public static boolean isPower(int a) 
    {
        
        if (a <= 1) 
        {
            return true;
        }
     
        for (int base = 2; base < a && base < Integer.MAX_VALUE / base; base++) 
        {
            int temp = base; 
            
            while (temp <= a && temp < Integer.MAX_VALUE / base) 
            {
                temp *= base;
                if (temp == a) return true;
            }
        }
     
    return false;
        
    }
	
	public static void main(String[] args)
	{
		
		System.out.println(isPower(4));
		
	}
	
}
