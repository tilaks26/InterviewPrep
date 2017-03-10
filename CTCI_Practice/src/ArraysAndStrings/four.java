import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main 
{
    public static String SEPARATOR = "@";
    public static final String COLON = ":";
    
    static class Holdings 
    {
        String ticker;
        String name;
        int quantity;
        
        public Holdings(String inputString) 
        {
            
            String[] array = inputString.split(",");
            ticker = array[0];
            name = array[1];
            quantity = Integer.parseInt(array[2]);
        }
        
        public String toString() 
        {
            return "[" + ticker + ", " + name + ", " + quantity + "]";
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

    static String generateTransactions(String input) 
    {
        String[] splitInput = input.split(COLON);
        String[] benchmarks = splitInput[0].split(SEPARATOR);
        String[] portfolios = splitInput[1].split(SEPARATOR);
        StringBuilder newString = new StringBuilder();
        List<Holdings> holdingsList = new ArrayList<Holdings>();
        List<Holdings> benchmarksList = new ArrayList<Holdings>();
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        
        for (String s : portfolios)
        {
            Holdings h = new Holdings(s);
            holdingsList.add(h);
        }
        
        for (String s : benchmarks)
        {
            Holdings h = new Holdings(s);
            benchmarksList.add(h);
        }
        
        Collections.sort(holdingsList, new ComparatorHoldings());
        Collections.sort(benchmarksList, new ComparatorHoldings());
        
        for (int i = 0; i < holdingsList.size(); i++)
        {
            Transactions t = new Transactions(holdingsList.get(i), benchmarksList.get(i));
            transactionsList.add(t);
        }
        
        for (int i = 0; i < transactionsList.size(); i++)
        {
            newString.append(transactionsList.get(i).toString());
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
        res = generateTransactions(_input);
        System.out.println(res);
    }
}