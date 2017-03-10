import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary 
{

	public static void main(String[] args)
	{
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("samsung");
		String s = "ilikesamsung";
		System.out.println(dp(s, dictionary));
	}
	
	public static boolean dp(String s, Set<String> dictionary)
	{
		int n = s.length();
		int[] pos = new int[n+1];
		
		Arrays.fill(pos, -1);
		pos[0] = 0;
		
		for (int i = 0; i < n; i++)
		{
			if (pos[i] != -1)
			{
				for (int j = i+1; j <= n; j++)
				{
					String substring = s.substring(i, j);
					if (dictionary.contains(substring))
					{
						pos[j] = i;
					}
				}
			}
		}
		
		return (pos[n] != -1);
	}
	
	public static boolean wordBreak(String s, Set<String> dictionary)
	{
		return wordBreakHelper(s, dictionary, 0);
	}
	
	public static boolean wordBreakHelper(String s, Set<String> dictionary, int start)
	{
		if (start == s.length())
			return true;
		
		for (String a : dictionary)
		{
			int len = a.length();
			int end = start + len;
			
			if (end > s.length())
			{
				continue;
			}
			
			if (s.substring(start, start+len).equals(a))
			{
				if (wordBreakHelper(s, dictionary, start+len))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
}