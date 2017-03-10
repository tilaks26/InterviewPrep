import java.util.ArrayList;

public class Facebook1 {

	public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
}
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sample1 = new ArrayList<Integer>();
		sample1.add(1);
		sample1.add(2);
		sample1.add(3);
		sample1.add(4);
		ArrayList<Integer> sample2 = new ArrayList<Integer>();
		sample1.add(5);
		sample1.add(6);
		sample1.add(7);
		sample1.add(8);
		ArrayList<Integer> sample3 = new ArrayList<Integer>();
		sample1.add(9);
		sample1.add(10);
		sample1.add(11);
		sample1.add(12);
		
		A.add(sample1);
		A.add(sample2);
		A.add(sample3);
		
		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
	    for (int j = 0; j < B.get(i).size(); j++) {
	            System.out.print(B.get(i).get(j) + " ");
	    }
	}
	}
	
}
