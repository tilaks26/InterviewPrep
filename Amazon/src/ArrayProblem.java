
public class ArrayProblem 
{
	
	public static void main(String[] args)
	{
		int[] array = {5,6,5,6,7,8,9,8,7};
		int k = 8;
		System.out.println(search(array,k));
	}

	public static int search(int[] array, int k)
	{
		int length = array.length;
		
		for (int i = Math.abs(k - array[0]); i < length - 1; )
		{
			if (k - array[i] == 0)
				return i;			
			i += Math.abs(array[i] - k);
		}
		return -1;
	}
	
}
