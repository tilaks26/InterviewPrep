public class Kadane 
{

	public static void main(String[] args)
	{
		int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(contiguousSubArraySum(nums));
	}
	
	public static int contiguousSubArraySum(int[] nums)
	{
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		int n = nums.length;
		int start = 0, end = 0, s = 0;
		
		for (int i = 0; i < n; i++)
		{
			max_ending_here += nums[i];
			
			if (max_so_far < max_ending_here)
			{
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			
			if(max_ending_here < 0)
			{
				max_ending_here = 0;
				s = i + 1;
			}
		}
		
		for (int i = start; i <= end; i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		
		return max_so_far;
	}
	
}