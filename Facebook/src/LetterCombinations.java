import java.util.LinkedList;
import java.util.List;

public class LetterCombinations 
{
	
	public static List<String> letterCombinations(String digits)
	{
		int n = digits.length();
		LinkedList<String> result = new LinkedList<String>();
		String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		if (digits == null || digits.length() == 0)
		{
			return result;
		}
		
		result.add("");
		
		for (int i = 0; i < n; i++)
		{
			int x = Character.getNumericValue(digits.charAt(i));
			
			while (result.peek().length() == i)
			{
				String top = result.remove();
				
				for (Character c : map[x].toCharArray())
				{
					result.add(top+c);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		for (String s : letterCombinations("79"))
		{
			System.out.print(s+" ");
		}
	}
	
}