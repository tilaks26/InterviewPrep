package ArraysAndStrings;

public class IsUnique 
{

	public static boolean isUnique(String string)
	{
		boolean unique = false;	
		for (char c : string.toCharArray())
		{
			if (string.indexOf(c) == string.lastIndexOf(c))
			{
				unique = true;
			}
			else
			{
				unique = false;
				return unique;
			}
		}		
		return unique;
	}
	
	public static void main(String[] args)
	{
		String string1 = "Hello";
		String string2 = "Delhi";		
		boolean testCase1 = isUnique(string1);
		boolean testCase2 = isUnique(string2);		
		if (testCase1 == true)
			System.out.println("The string "+string1+" is unique.");
		else
			System.out.println("The string "+string1+" is not unique.");		
		if (testCase2 == true)
			System.out.println("The string "+string2+" is unique.");
		else
			System.out.println("The string "+string2+" is not unique.");		
	}
	
}