import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses 
{
	
	public static ArrayList<String> result = new ArrayList<String>();
	public static int max = 0;

	public static void main(String[] args)
	{
		String s = "(a)())()";
		List<String> list = removeInvalidParentheses(s);
		for (String l : list)
		{
			System.out.println(l);
		}
	}
	
	public static List<String> removeInvalidParentheses(String s)
	{
		if (s == null)
		{
			return result;
		}
		
		dfs(s, "", 0, 0);
		
		if (result.size() == 0)
		{
			result.add("");
		}
		
		return result;
	}
	
	public static void dfs(String left, String right, int countLeft, int maxLeft)
	{
		if (left.length() == 0)
		{
			if (countLeft == 0 && right.length() != 0)
			{
				if (maxLeft > max)
				{
					max = maxLeft;
				}
				if (maxLeft == max && !result.contains(right))
				{
					result.add(right);
				}
			}
			return;
		}
		
		if (left.charAt(0) == '(')
		{
			dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);
			dfs(left.substring(1), right, countLeft, maxLeft);
		}
		
		else if (left.charAt(0) == ')')
		{
			if (countLeft > 0)
			{
				dfs(left.substring(1), right+")", countLeft-1, maxLeft);
			}
			dfs(left.substring(1), right, countLeft, maxLeft);
		}
		
		else
		{
			dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
		}
	}
	
}
