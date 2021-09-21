package java8;

public class DivideConquerPow {
	
	public static void main(String args[])
	{
		int[][] sm ={{1,1},{1,1}};
		sm = pow(sm,10);

		
		
		for(int i = 0 ; i<sm.length;i++)
		{
			for(int j = 0 ; j < sm[i].length; j++)
			{
				System.out.print(sm[i][j]+" ");
			}
			System.out.println();
		}

	}
	public static int[][] multiply(int[][] a, int[][] sm)
	{
		int temp[][]=new int[sm.length][sm.length];
		for(int i = 0; i < sm.length; i++)
		{
			for(int j = 0 ; j <sm.length; j++)
			{
				for(int k = 0 ; k < sm.length; k++)
				{
					temp[i][j] += a[i][k]*sm[k][j];
				}
			}
		}
		return temp;
	}
	
	public static int[][] pow(int[][] a, int m)
	{
		if(m == 0) return identity();
		if(m%2>0) return multiply(a, pow(a,m-1));
		int[][] half = pow(a, m/2);
		return multiply(half, half);
	}

	public static int[][] identity()
	{
		int[][] sm = {{1,0},{0,1}};
		return sm;
	}
}
/*
class SquareMatrix{
	
	public int[][] a;
	
	public SquareMatrix(int n)
	{
		this.a = new int[n][n];
	}
	
	public SquareMatrix multiply(SquareMatrix sm)
	{
		int temp[][]=new int[a.length][a.length];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0 ; j < a.length; j++)
			{
				for(int k = 0 ; k < a.length; k++)
				{
					temp[i][j] += a[i][k]*sm.a[k][j];
				}
			}
		}
		this.a=temp;
		return this;
	}
	public void printMatrix()
	{
		for(int i = 0 ; i<a.length;i++)
		{
			for(int j = 0 ; j < a[i].length; j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
*/