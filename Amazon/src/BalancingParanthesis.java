import java.util.Stack;

public class BalancingParanthesis 
{

	public static void main(String[] args)
	{
		String para = "(()())";
		if (check(para))
		{
			System.out.println("Balanced");
		}
		else
		{
			System.out.println("Not Balanced");
		}
	}
	
	public static boolean check(String para)
	{
		Stack<Character> s = new Stack<Character>();
		char[] array = para.toCharArray();
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == '(')
			{
				s.push(array[i]);
			}
			else
			{
				s.pop();
			}
		}
		if (s.isEmpty())
		{
			return true;
		}
		return false;
	}
	
}
