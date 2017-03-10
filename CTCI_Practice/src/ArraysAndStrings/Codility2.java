package ArraysAndStrings;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Codility2 
{
 public int solution(int[] A) 
 {
     // write your code in Java SE 8
     
     int start = 0, end = 0;
     
     for (start = 0; start < A.length - 1; start++)
     {
         if (A[start] > A[start+1])
         {
             break;
         }
     }
     
     if (start  == A.length - 1)
     {
         return 0;
     }
     
     for (end = A.length - 1; end > 0; end--)
     {
         if (A[end] < A[end-1])
         {
             break;
         }
     }
     
     int maximum = A[start];
     int minimum = A[start];
     
     for (int i = start + 1; i <= end; i++)
     {
         if (A[i] > maximum)
         {
             maximum = A[i];
         }
         if (A[i] < minimum)
         {
             minimum = A[i];
         }
     }
     
     for (int i = 0; i < start; i++)
     {
         if (A[i] > minimum)
         {
             start = i;
             break;
         }
     }
     
     for (int i = A.length - 1; i >= end + 1; i--)
     {
         if (A[i] < maximum)
         {
             end = i;
             break;
         }
     }
     
     int result = end - start + 1;
     
     return result;
     
 }
}
