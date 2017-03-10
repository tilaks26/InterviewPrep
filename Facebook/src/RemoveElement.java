import java.util.ArrayList;

public class RemoveElement 
{

	public static int removeElement(ArrayList<Integer> a, int b) 
	{
	    int i = 0;
	    for (int j = 0; j < a.size(); j++) 
	    {
	        if (a.get(j) != b) 
	        {
	            a.set(i, a.get(j));
	            i++;
	        }
	    }
	    return i;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(4);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(3);
		
		int integer = 1;
		
		System.out.println(removeElement(arrayList, integer));
		
	}
	
}
