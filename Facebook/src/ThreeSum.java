import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum 
{

	public static List<List<Integer>> findSum(int[] arr, int sum)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = arr.length;
		
		if (arr == null || n == 0)
		{
			return result;
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i< n - 2; i++)
		{
			if (i == 0 || arr[i] > arr[i-1])
			{
				int l = i+1;
				int r = n-1;
			
				while (l<r)
				{
					if (arr[i] + arr[l] + arr[r] == sum)
					{
						List<Integer> list = new ArrayList<Integer>();
						list.add(arr[i]);
						list.add(arr[l]);
						list.add(arr[r]);
						result.add(list);
						l++;
						r--;
					
						while (l < r && arr[l] == arr[l-1])
						{
							l++;
						}
						
						while (l < r && arr[r] == arr[r+1])
						{
							r--;
						}
					}
					
				
					else if (arr[i] + arr[l] + arr[r] < sum)
					{
						l++;
					}
					
					else
					{
						r--;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {-1, 0, 1, 2, -1, -4};
		int sum = -2;
		
		for (List<Integer> list : findSum(arr, sum))
		{
			System.out.println(list);
		}
	}
	
}