public class Celebrity 
{
	
	public static boolean knows(int a, int b)
	{
		return true;
	}
	
	public static int findCelebrity(int n)
	{
		if (n <= 1)
		{
			return -1;
		}
		
		int[] inDegree = new int[n];
		int[] outDegree = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i != j && knows(i, j))
				{
					outDegree[i]++;
					inDegree[j]++;
				}
			}
		}
		
		for (int i = 0; i < n; i++)
		{
			if (inDegree[i] == n-1 && outDegree[i] == 0)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static int findCelebrityO(int n)
	{
		if (n <= 1)
		{
			return -1;
		}
		
		int left = 0;
		int right = n-1;
		
		while (left < right)
		{
			if (knows(left, right))
			{
				left++;
			}
			
			else
			{
				right--;
			}
		}
		
		int candidate = right;
		
		for (int i = 0; i < n; i++)
		{
			if (i != candidate && (!knows(i, candidate) || knows(candidate, i)))
			{
				return -1;
			}
		}
		
		return candidate;
	}
	
}