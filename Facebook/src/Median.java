public class Median 
{

	public static void main(String[] args)
	{
		
		int[] a = {3, 6, 1, 4};
		
		System.out.println("Median: "+median(a));
		
	}
	
	public static double median(int[] a) 
	{
        int len = a.length;
        if(len % 2 == 1) 
        {
            return topK(a, len / 2);
        } 
        else 
        {
            return (topK(a, len / 2 - 1) + topK(a, len / 2)) * .5;
        }
    }

    public static int topK(int[] a, int k) 
    {
        int l = 0, r = a.length - 1;
        while(l <= r) 
        {
            int pivot = a[l];
            int i = l + 1, j = r;
            while(i <= j) 
            {
                if(a[i] <= pivot) 
                {
                	i++;
                }
                else if(a[j] > pivot) 
                {
                	j--;
                }
                else 
                {
                	int temp = a[i];
                	a[i] = a[j];
                	a[j] = temp;
                    i++;
                    j--;
                }
            }
            if(j == k) 
            {
            	return pivot;
            }
            else if(j < k) 
            {
            	l = i;
            }
            else 
            {
            	int temp = a[l];
            	a[l] = a[j];
            	a[j] = temp;
                r = j - 1;
            }
        }
        return a[r];
    }
	
}