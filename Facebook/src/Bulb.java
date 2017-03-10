import java.util.ArrayList;

public class Bulb 
{

	public static int bulbs(ArrayList<Integer> a) 
    {
        int bulbState = 0;
        int switches = 0;
        
        for (int i = 0; i < a.size(); i++)
        {
            if (bulbState == a.get(i))
            {
                bulbState = 1 - bulbState;
                switches++;
            }
        }
        return switches;
    }
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(0);
		a.add(1);
		System.out.println(bulbs(a));
	}
	
}
