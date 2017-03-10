package ArraysAndStrings;

public class SumZero 
{

	public static void main(String[] args)
	{
		int[] array = {-1, 5, 3, 4, 9};
		int[] result = sum(array);
		System.out.println("Smallest: "+result[0]+"; Second Smallest: "+result[1]);
	}
	
	public static int[] sum(int[] array)
	{
		int length = array.length;
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++)
		{
			if (array[i] < smallest)
			{
				secondSmallest = smallest;
				smallest = array[i];
			}
			else if (array[i] < secondSmallest)
			{
				secondSmallest = array[i];
			}
		}
		int[] result = {smallest, secondSmallest};
		return result;
	}
	
}
