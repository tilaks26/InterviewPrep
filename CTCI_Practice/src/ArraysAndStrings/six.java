package ArraysAndStrings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main 
{
    
	public static final String SEPARATOR = "@";
    public static final String COLON = ":";
    public static double NAV = 0;
    
    static class Holdings 
	{
		String ticker;
	    String name;
	    int quantity;
	    double price;
	    double value;
	    double netAssetValue;
	    
	    public Holdings(String inputString) 
	    {
	        
	        String[] array = inputString.split(",");
	        ticker = array[0];
	        name = array[1];
	        quantity = Integer.parseInt(array[2]);
	        try
	        {
	            price = Double.parseDouble(array[3]);
	        }
	        catch (Exception exception)
	        {
	            price = 0;
	        }
	    }
	}
    
    static class ComparatorHoldings implements Comparator<Holdings> 
    {
        @Override
        public int compare (Holdings holdings1, Holdings holdings2) 
        {
            return holdings1.ticker.compareTo(holdings2.ticker);
        }
    }
    
    static class Transactions 
	{
		String type;
		String ticker;
		double quantity;

		public Transactions(Double difference, String ticker, double quantity) 
		{
			if (difference > 0)
			{
				this.type = "BUY";
			}
			else
			{
				this.type = "SELL";
			}
			
			this.ticker = ticker;
			this.quantity = quantity;
		}
		
		@Override
		public String toString()
		{
			return "[" + type + ", " + ticker + ", "
					+ String.format("%.2f", quantity) + "]";
		}
	}
    
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */


    static String generateTransactions(String inputString) 
    {
        String[] splitInput = inputString.split(COLON);
        String[] portfolios = splitInput[0].split(SEPARATOR);
        String[] benchmarks = splitInput[1].split(SEPARATOR);
        StringBuilder newString = new StringBuilder();
        ArrayList<Holdings> portfoliosList = new ArrayList<Holdings>();
        ArrayList<Holdings> benchmarksList = new ArrayList<Holdings>();
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        
        for (String s : portfolios)
        {
            if (s != null && s != "")
            {
                Holdings h = new Holdings(s);
                portfoliosList.add(h);
            }
        }
        
        for (String s : benchmarks)
        {
            if (s != null && s != "")
            {
                Holdings h = new Holdings(s);
                benchmarksList.add(h);
            }
        }
        
		Collections.sort(portfoliosList, new ComparatorHoldings());
		Collections.sort(benchmarksList, new ComparatorHoldings());
		
		double portfolioNAV = 0;
		double benchmarkNAV = 0;
		
		for (int i = 0; i < portfoliosList.size(); i++) 
		{
			Holdings portfolio = portfoliosList.get(i);
			Holdings benchmark = benchmarksList.get(i);
			portfolio.price = benchmark.price;
			portfolio.value = benchmark.price * portfolio.quantity;
			benchmark.value = benchmark.price * benchmark.quantity;
			portfolioNAV += benchmark.price * portfolio.quantity;
			benchmarkNAV += benchmark.price * benchmark.quantity;
		}
		
		for (int i = 0; i < portfoliosList.size(); i++) 
		{
			double nav = ((portfoliosList.get(i).value) / portfolioNAV) * 100;
			portfoliosList.get(i).netAssetValue = nav;
			nav = ((benchmarksList.get(i).value) / benchmarkNAV) * 100;
			benchmarksList.get(i).netAssetValue = nav;
		}
		
		for (int i = 0; i < portfoliosList.size(); i++) 
		{
			double nav = benchmarksList.get(i).netAssetValue;
			double difference = (portfolioNAV * nav) / 100 - portfoliosList.get(i).value;
			double quantity = difference / portfoliosList.get(i).price;
			quantity = Math.round(quantity * 100.0) / 100.0;
			Transactions transactions = new Transactions(difference, portfoliosList.get(i).ticker, quantity);
			transactionsList.add(transactions);
		}

		for (Transactions transaction : transactionsList) 
		{
			newString.append(transaction.toString());
			newString.append(", ");
		}
		
		newString.deleteCharAt(newString.length() - 1);
        newString.deleteCharAt(newString.length() - 1);
        
        return newString.toString(); 
    }
    
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        res = generateTransactions(_input);
        System.out.println(res);
    }
}
