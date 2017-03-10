package ArraysAndStrings;

public class OddElement 
{

	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 1, 3, 2, 3};
		System.out.println("Number: "+oddEle(array));		
	}
	
	public static int oddEle(int[] array)
	{
		int size = array.length;
		int result = 0;
		for (int i = 0; i < size; i++)
		{
			System.out.print(result+" ^ "+array[i]);
			result = result ^ array[i];
			System.out.println(" = "+result);
		}
		return result;
	}
	
}
