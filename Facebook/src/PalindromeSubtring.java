import java.util.Arrays;

public class PalindromeSubtring 
{

	public static String longestPalindrome1(String s)
	{
		int n = s.length();
		int longestBegin = 0;
		int maximumLength = 1;
		boolean[][] table = new boolean[1000][1000];
		for (boolean bool[] : table)
		{
			Arrays.fill(bool, false);
		}
		
		for (int i = 0; i < n; i++)
		{
			table[i][i] = true;
		}
		
		for (int i = 0; i < n-1; i++)
		{
			if (s.charAt(i) == s.charAt(i+1))
			{
				table[i][i+1] = true;
				longestBegin = i;
				maximumLength = 2;
			}
		}
		
		for (int len = 3; len <= n; len++)
		{
			for (int i = 0; i < n-len+1; i++)
			{
				int j = i + len - 1;
				if ((s.charAt(i) == s.charAt(j)) && (table[i+1][j-1]))
				{
					table[i][j] = true;
					longestBegin = i;
					maximumLength = len;
				}
			}
		}
		
		return s.substring(longestBegin, maximumLength+1);
	}
	
	public static String expandAroundCenter(String s, int c1, int c2)
	{
		int l = c1, r = c2;
		int n = s.length();
		
		while((l >= 0) && (r <= n-1) && (s.charAt(l) == s.charAt(r)))
		{
			l--;
			r++;
		}
		
		return s.substring(l+1, r-l-1);
	}
	
	public static String longestPalindrome2(String s)
	{
		int n = s.length();
		
		if(n == 0)
		{
			return "";
		}
		
		String longest = s.substring(0, 1);
		
		for (int i = 0; i < n-1; i++)
		{
			String p1 = expandAroundCenter(s, i, i);
			if(p1.length() > longest.length())
			{
				longest = p1;
			}
			
			String p2 = expandAroundCenter(s, i, i+1);
			if (p2.length() > longest.length())
			{
				longest = p2;
			}
		}
		
		return longest;
	}
	
	public static void main(String[] args)
	{
		String s = "babcbabcbaccba";
		System.out.println(longestPalindrome2(s));
	}
	
}
