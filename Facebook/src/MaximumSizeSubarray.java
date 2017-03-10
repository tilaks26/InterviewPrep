import java.util.HashMap;

public class MaximumSizeSubarray 
{

	public static int maxSubArrayLen(int[] nums, int k) 
	{
		int n = nums.length;
		
        if (nums == null || n == 0)
        {
        	return 0;
        }
        
        int maxLength = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        
        for (int i = 0; i < n; i++)
        {
        	sum += nums[i];
        	
        	if (!map.containsKey(sum))
        	{
        		map.put(sum, i);
        	}
        	
        	if (map.containsKey(sum-k))
        	{
        		int index = map.get(sum-k);
        		maxLength = Math.max(maxLength, i-index);
        	}
        }
        
        return (maxLength == Integer.MIN_VALUE ? 0 : maxLength);
    }
	
	public static void main(String[] args)
	{
		int[] nums = {-2, -1, 2, 1};
		int k = 1;
		System.out.println(maxSubArrayLen(nums, k));
	}
	
}