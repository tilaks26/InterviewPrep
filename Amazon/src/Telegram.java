import java.util.ArrayList;

public class Telegram 
{
	    
	    public static void main(String[] args)
	    {
	        int n = Integer.parseInt(args[0]);
	        String input = new String();
	        for (int i = 1; i < args.length; i++)
	        {
	            input += args[i];
	        }
//	    	int n = 15;
//	    	String input = "The quick brown fox jumped over the lazy dog";
	        ArrayList<String> result = splitText(input, n);
	        for (int j = 0; j < result.size(); j++)
	        {
	            System.out.println(result.get(j));
	        }
	    }
	    
	    public static ArrayList<String> splitText(String input, int n)
	    {
	        ArrayList<String> result = new ArrayList<String>();
	        String[] array = input.split(" ");
	        String out = new String();
	        
	        for (int i = 0; i < array.length; i++)
	        {
	        	String a = out + array[i];
	        	if (a.length() <= n)
	        	{
	        		out += array[i];
	        		out += " ";
	        	}
	        	else
	        	{
	        		result.add(out);
	        		out = array[i];
	        		out += " ";
	        	}
	        }
	        result.add(out);
	        return result;
	    }

	
}
