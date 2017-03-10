package ArraysAndStrings;

public class URLify 
{

	public static void main(String[] args)
	{
		String string = "Mr John Smith            ";
		int length = 13;
		//System.out.println("URL - "+makeURL(string, length));
		String s = "abcabcbb";
		String sub = "";
		char c = ' ';
        for (int i = 0; i < s.length(); i++)
        {
        	if (s.charAt(i) != c)
        	{
        		c = s.charAt(i);
        		sub = sub + Character.toString(c);
        	}
        	else
        	{
        		break;
        	}
        }
        System.out.println(sub.length());
	}
	
	public static String makeURL(String string, int length)
	{
		char[] array = string.toCharArray();
		int count = 0;
		for (int i = 0; i < length; i++)
		{
			if (array[i] == ' ')
			{
				count ++;
			}
		}
		int index = length + count * 2;
		if (length < array.length)
		{
			array[length] = '\0';
		}
		for (int i = length - 1; i >= 0; i++)
		{
			if (array[i] == ' ')
			{
				array[index - 1] = '0';
				array[index - 2] = '2';
				array[index - 3] = '%';
				index = index - 3;
			}
			else
			{
				array[index - 1] = array[i];
				index --;
			}
		}
		return array.toString();
	}
	
}
