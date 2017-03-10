import java.util.HashMap;

public class NumberToWords 
{

	public static HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public static void fillMap()
	{
		map.put(0, "Zero");
		map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
	}
	
	public static String convert(int num)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		if (num >= 100)
		{
			int hundred = num/100;
			stringBuilder.append(" "+map.get(hundred)+" Hundred");
			num = num%100;
		}
		
		if (num > 0)
		{
			if (num > 0 && num <= 20)
			{
				stringBuilder.append(" "+map.get(num));
			}
			else
			{
				int ten = num/10;
				stringBuilder.append(" "+map.get(ten*10));
				int one = num%10;
				if (one > 0)
				{
					stringBuilder.append(" "+map.get(one));
				}
			}
		}
		
		return stringBuilder.toString();
	}
	
	public static String numberToWords(int num)
	{
		fillMap();
		StringBuilder stringBuilder = new StringBuilder();
		
		if (num == 0)
		{
			return map.get(0);
		}
		
		if (num >= 1000000000)
		{
				int extra = num/1000000000;
				stringBuilder.append(convert(extra) + " Billion");
				num = num%1000000000;
		}
		
		if (num >= 1000000)
		{
			int extra = num/1000000;
			stringBuilder.append(convert(extra) + " Million");
			num = num%1000000;
		}
		
		if (num >= 1000)
		{
			int extra = num/1000;
			stringBuilder.append(convert(extra) + " Thousand");
			num = num%1000;
		}
		
		if (num > 0)
		{
			stringBuilder.append(convert(num));
		}
		
		return stringBuilder.toString().trim();
	}
	
	public static void main(String[] args)
	{
		System.out.println(numberToWords(1234));
	}
	
}