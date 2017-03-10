public class SparseMatrixMultiplication 
{

	public static void main(String[] args)
	{
		int[][] A = {{0, 0, 0},{5, 8, 0},{0, 0, 3}};
		int[][] B = {{0, 1, 0},{9, 0, 0},{0, 0, 0}};
		int[][] C = multiply(A, B);
		
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < B.length; j++)
			{
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] multiply(int[][] A, int[][] B)
	{
		int[][] C = new int[A.length][B[0].length];
		
		for (int i = 0; i < A.length; i++)
		{
			for (int k = 0; k < A[0].length; k++)
			{
				if (A[i][k] != 0)
				{
					for (int j = 0; j < B[0].length; j++)
					{
						C[i][j] += A[i][k]*B[k][j];
					}
				}
			}
		}
		
		return C;
	}
	
}