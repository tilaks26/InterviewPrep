public class MoveZeroes 
{

    public static int[] moveZeroes(int[] nums) 
    {	
    	int index = 0;
        int length = nums.length;
        
        for (int i = 0; i < length; i++)
        {
            if (nums[i] != 0)
            {
                nums[index++] = nums[i];
            }
        }
        
        while (index < length)
        {
        	nums[index++] = 0;
        }
        
        return nums;  
    }
    
    public static void main(String[] args)
    {
    	int[] nums = {0, 1, 0, 3, 12};
    	nums = moveZeroes(nums);
    	for (int i = 0; i < nums.length; i++)
    	{
    		System.out.print(nums[i]+" ");
    	}
    }
	
}
