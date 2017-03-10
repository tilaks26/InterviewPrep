import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandProblem 
{

	public static int numIslands(char[][] grid)
	{
		if (grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (grid[i][j] == '1')
				{
					count++;
					merge(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	public static void merge(char[][] grid, int i, int j)
	{
		int m = grid.length;
		int n = grid[0].length;
		
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
		{
			return;
		}
		
		grid[i][j] = 'X';
		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j-1);
		merge(grid, i, j+1);
	}
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) 
	{
	    int[] rootArray = new int[m*n];
	    Arrays.fill(rootArray,-1);
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	    int count=0;
	 
	    for(int k=0; k<positions.length; k++)
	    {
	        count++;
	        int[] p = positions[k];
	        int index = p[0]*n+p[1];
	        rootArray[index]=index;//set root to be itself for each node
	 
	        for(int r=0;r<4;r++)
	        {
	            int i=p[0]+directions[r][0];
	            int j=p[1]+directions[r][1];
	 
	            if(i>=0&&j>=0&&i<m&&j<n&&rootArray[i*n+j]!=-1)
	            {
	                //get neighbor's root
	                int thisRoot = getRoot(rootArray, i*n+j);
	                if(thisRoot!=index)
	                {
	                    rootArray[thisRoot]=index;//set previous root's root
	                    count--;
	                }
	            }
	        }
	 
	        result.add(count);
	    }
	 
	    return result;
	}
	 
	public int getRoot(int[] arr, int i)
	{
	    while(i!=arr[i])
	    {
	        i=arr[i];
	    }
	    
	    return i;
	}
	
}