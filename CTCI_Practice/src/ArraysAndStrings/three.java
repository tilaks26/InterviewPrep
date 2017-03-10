import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    
    public static final String SEPARATOR = "@";
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
    
    /*
     * Complete the function below.
     *
	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String printHoldings(String portfolioString) 
    {

        String[] benchmarks = portfolioString.split(COLON);
        String[] portfolios = benchmarks[1].split(SEPARATOR);
        StringBuilder newString = new StringBuilder();
        List<Holdings> holdingsList = new ArrayList<Holdings>();
        
        for (String s : portfolios)
        {
            Holdings h = new Holdings(s);
            holdingsList.add(h);
        }
        
        Collections.sort(holdingsList, new ComparatorHoldings());
        
        for (int i = 0; i < holdingsList.size(); i++)
        {
            newString.append(holdingsList.get(i).toString());
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
        res = printHoldings(_input);
        System.out.println(res);
    }
}