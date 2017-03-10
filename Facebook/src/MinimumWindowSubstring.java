import java.util.HashMap;

public class MinimumWindowSubstring 
{

	public static void main(String[] args)
	{
		System.out.println(minimumWindow("ADOBECODEBANC", "ABC"));
	}
	
	public static String minimumWindow(String s, String t) 
    {
        int sLength = s.length();
        int tLength = t.length();
        
        if (tLength > sLength)
        {
            return "";
        }
        
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        String result = "";
        
        for (int i = 0; i < tLength; i++)
        {
            char tChar = t.charAt(i);
            
            if (tMap.containsKey(tChar))
            {
                tMap.put(tChar, tMap.get(tChar)+1);
            }
            
            else
            {
                tMap.put(tChar, 1);
            }
        }
        
        int left = 0;
        int count = 0;
        int minimumLength = sLength + 1;
        
        for (int i = 0; i < sLength; i++)
        {
            char sChar = s.charAt(i);
            
            if (tMap.containsKey(sChar))
            {
                if (sMap.containsKey(sChar))
                {
                    if (sMap.get(sChar) < tMap.get(sChar))
                    {
                        count++;
                    }
                    sMap.put(sChar, sMap.get(sChar)+1);
                }
                else
                {
                    sMap.put(sChar, 1);
                    count++;
                }
            }
            
            if (count == tLength)
            {
                char c = s.charAt(left);
                
                while (!sMap.containsKey(c) || sMap.get(c) > tMap.get(c))
                {
                    if (sMap.containsKey(c) && sMap.get(c) > tMap.get(c))
                    {
                        sMap.put(c, sMap.get(c)-1);
                    }
                    
                    left++;
                    c = s.charAt(left);
                }
                
                if (i-left+1 < minimumLength)
                {
                    result = s.substring(left, i+1);
                    minimumLength = i-left+1;
                }
            }
        }
        
        return result;
    }
	
}