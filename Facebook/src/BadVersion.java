public class BadVersion 
{
	
	public static boolean isBadVersion(int num)
	{
		return true;
	}

	public static int firstBadVersion(int n) 
	{
		int start = 0;
		int end = n;
		
		while (start < end)
		{
			int mid = start + (end - start) / 2;
			
			if (!isBadVersion(mid))
			{
				start = mid + 1;
			}
			else
			{
				end = mid;
			}
		}
		
		return start;
	}
	
}