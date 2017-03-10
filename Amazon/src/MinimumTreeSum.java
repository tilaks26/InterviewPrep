public class MinimumTreeSum 
{

	public static void main(String[] args)
	{
		int[] array = {3,1,2};
		System.out.println(minSwap(array));
	}
	
		public static int minSwap(int[] array) 
		{		
			int i, j, first, temp;  
			int minimum=0;
		     for ( i = array.length - 1; i > 0; i--)  
		     {
		          first = 0;   //initialize to subscript of first element
		          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
		          {
		               if( array[ j ] < array[ first ] )   
		                 first = j;
		          }
		          temp = array[ first ];   //swap smallest found with element in position i.
		          array[ first ] = array[ i ];
		          array[ i ] = temp;
		      }
		     return minimum;
		}
}