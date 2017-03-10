public class ReverseString 
{
	
	public static void main(String[] args)
	{
		String s = "Final song";
		char[] arr = s.toCharArray();
		System.out.println(reverseString(arr, 0, arr.length - 1));
	}
	
	public static String reverseString(char[] arr, int start, int end)
	{
		
		if (start >= end)
		{
			return String.valueOf(arr);
		}
		
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		return reverseString(arr, start+1, end-1);
	}
	
}