package ArraysAndStrings;

public class MinimumNumber 
{

	public static void main(String[] args)
	{
		int[] array = {4, 2, 1, 2, 3, 4, 5, 6};
		int low = 0;
		int high = array.length - 1;
		int result = minimum(array, low, high);
		if (result == -1)
		{
			System.out.println("Error");
			return;
		}
		System.out.println(result);
	}
	
	public static int minimum(int[] array, int low, int high)
	{
		int mid = low + (high - low)/2;
		int min = array[mid];
		
		if (array.length == 1)
		{
			return array[0];
		}
		
		else if (array.length == 2)
		{
			return array[1] > min ? min : array[1];
		}
		
		if (low > high)
			return -1;
		
		if (array[low] > array[mid] && array[mid + 1] < array[high])
		{
			if (array[mid] < array[mid + 1])
				return minimum(array, low, mid);
			else
				return minimum(array, mid + 1, high);
		}
		return min;
	}
	
}
