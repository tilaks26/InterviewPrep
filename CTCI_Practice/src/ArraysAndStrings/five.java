import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
        
        @Override
        public String toString() 
        {
            return "[" + ticker + ", " + name + ", " + quantity + ", " +
            String.format("%.2f", price) + ", " + String.format("%.2f", price * quantity) + 
            ", " + String.format("%.2f", ((price * quantity * 100)/NAV)) + "]";
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
        
        public Transactions(Holdings portfolio, Holdings benchmark)
        {
            if (portfolio.quantity > benchmark.quantity)
            {
                type = "BUY";
            }
            else
            {
                type = "SELL";
            }
            ticker = portfolio.ticker;
            quantity = Math.abs(portfolio.quantity - benchmark.quantity);
        }
        
        @Override
        public String toString()
        {
            return "[" + type + ", " + ticker + ", " + String.format("%.2f", quantity) + "]";
            
        }
    }
    
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String printHoldingsWithWeight(String inputString) 
    {
		String[] splitInput = inputString.split(COLON);
        String[] portfolios = splitInput[0].split(SEPARATOR);
        String[] benchmarks = splitInput[1].split(SEPARATOR);
        StringBuilder newString = new StringBuilder();
        List<Holdings> portfoliosList = new ArrayList<Holdings>();
        List<Holdings> benchmarksList = new ArrayList<Holdings>();
        
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
        
        for (int i = 0; i < portfoliosList.size(); i++)
        {
            portfoliosList.get(i).price = benchmarksList.get(i).price;
            NAV += (benchmarksList.get(i).price * portfoliosList.get(i).quantity); 
        }
        
        for (Holdings h : portfoliosList)
        {
            newString.append(h);
            newString.append(", ");
        }
        
        newString.deleteCharAt(newString.length() - 1);
        newString.deleteCharAt(newString.length() - 1);
        
        return newString.toString();
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        res = printHoldingsWithWeight(_input);
        System.out.println(res);
    }
}