package ArraysAndStrings;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Codility1 
{
 public String solution(int A, int B, int C, int D) 
 {
     // write your code in Java SE 8
     
     List<Integer> inputList = new ArrayList<Integer>();
     inputList.add(A);
     inputList.add(B);
     inputList.add(C);
     inputList.add(D);
     
     int h1 = -1;
     int h2 = -1;
     int m1 = -1;
     int m2 = -1;
     
     for (int a : inputList)
     {
         if (a <= 2 && a > h1)
         {
             h1 = a;
         }
     }
     
     inputList.remove(Integer.valueOf(h1));
     
     for (int a : inputList)
     {
         if (h1 == 2 && a <= 3 && a > h2)
         {
             h2 = a;
         }
     }
     
     if (h2 == -1)
     {
         for (int a : inputList)
         {
             if (a > h2)
             {
                 h2 = a;
             }
         }
     }
     
     inputList.remove(Integer.valueOf(h2));
     
     for (int a : inputList)
     {
         if (a <= 5 && a > m1)
         {
             m1 = a;
         }
     }
     
     inputList.remove(Integer.valueOf(m1));
     
     m2 = inputList.get(0);
     
     StringBuilder result = new StringBuilder(5);
     result.append(h1+""+h2+':'+m1+""+m2);
     
     if (h1 == -1 || h2 == -1 || m1 == -1 || m2 == -1)
     {
         return "NOT POSSIBLE";
     }
     
     return result.toString();
     
 }
}