import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    
    public static final String SEPARATOR = "@";
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String printHoldings(String portfolioString) {
        
        String[] inputString = portfolioString.split(SEPARATOR);
        StringBuilder output = new StringBuilder();
        List<Holdings> sortedOutput = new ArrayList<Holdings>();
        
        for (String item : inputString) {
            Holdings holdings = new Holdings(item);
            sortedOutput.add(holdings);
        }
        
        Collections.sort(sortedOutput, new HoldingComparator());
        
        for (int i = 0; i < sortedOutput.size(); i++) {
            output.append(sortedOutput.get(i).toString());
            output.append(", ");
        }
        
        output.deleteCharAt(output.length() - 1);
        output.deleteCharAt(output.length() - 1);
        
        return output.toString();
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
    
    static class Holdings 
    {
        
        String ticker;
        String name;
        int quantity;
        
        public Holdings(String input) {
            
            String[] parts = input.split(",");
            ticker = parts[0];
            name = parts[1];
            quantity = Integer.parseInt(parts[2]);
        }
        
        public String toString() {
            return "[" + ticker + ", " + name + ", " + quantity + "]";
        }
    }
    
    static class HoldingComparator implements Comparator<Holdings> {
        @Override
        public int compare (Holdings h1, Holdings h2) {
            return h1.ticker.compareTo(h2.ticker);
        }
    }
}