package ArraysAndStrings;

public class RotatedSearch 
{

	public static void main (String[] args)
	{
		//int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		//int[] array = {1, 2, 3, 4, 5, 6};
		int[] array = {6, 5, 4, 3, 2, 1};
		int length = array.length;
		int low = 0;
		int high = length - 1;
		int result = search(array, 6, low, high);
		if (result == -1)
		{
			System.out.println("Element not found.");
			return;
		}
		System.out.println("Index: "+result);
	}
	
	public static int search(int[] array, int element, int low, int high)
	{
		int mid = low + (high - low)/2;
		
		if (element == array[mid])
		{
			return mid;
		}
		
		if (low > high)
		{
			return -1;
		}
		
		else if (array[low] < array[high])
		{
			if (element < array[mid])
			{
				return search(array, element, low, mid - 1);
			}
			else
			{
				return search(array, element, mid+1, high);
			}
		}
		
		else if (element >= array[low])
		{
			return search(array, element, low, mid - 1);
		}
		else
		{
			return search(array, element, mid + 1, high);
		}
		
//		else if (element > array[mid])
//		{
//			if (element >= array[low])
//			{
//				return search(array, element, low, mid - 1);
//			}
//			else
//			{
//				return search(array, element, mid + 1, high);
//			}
//		}
//		
//		else
//		{
//			if (element >= array[low])
//			{
//				return search(array, element, low, mid - 1);
//			}
//			else
//			{
//				return search(array, element, mid + 1, high);
//			}
//		}	
	}	
}
