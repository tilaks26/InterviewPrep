package ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation 
{

	public static boolean checkPermutation(String string1, String string2)
	{
		if (string1.length() != string2.length())
		{
			return false;
		}
		char[] array1 = string1.toCharArray();
		char[] array2 = string2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}
	
	public static void main (String[] args)
	{
		String string1 = "top";
		String string2 = "pot";
		String string3 = "cup";
		String string4 = "train";
		boolean testCase1 = checkPermutation(string1, string2);
		boolean testCase2 = checkPermutation(string1, string3);
		boolean testCase3 = checkPermutation(string1, string4);
		if (testCase1 == true)
		{
			System.out.println("String "+string1+" is a permutation of "+string2+".");
		}
		else
		{
			System.out.println("String "+string1+" is not a permutation of "+string2+".");
		}
		if (testCase2 == true)
		{
			System.out.println("String "+string1+" is a permutation of "+string3+".");
		}
		else
		{
			System.out.println("String "+string1+" is not a permutation of "+string3+".");
		}
		if (testCase3 == true)
		{
			System.out.println("String "+string1+" is a permutation of "+string4+".");
		}
		else
		{
			System.out.println("String "+string1+" is not a permutation of "+string4+".");
		}
	}
	
}
