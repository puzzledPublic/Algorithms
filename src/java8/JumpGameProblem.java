package java8;

import java.util.Scanner;

public class JumpGameProblem {

	final static int n = 7, board[][]={{2,5,1,6,1,4,1},
									   {6,1,1,2,2,9,3},
									   {7,2,3,2,1,3,1},
									   {1,1,3,1,7,1,2},
									   {4,1,2,3,4,1,2},
									   {3,3,1,2,3,4,1},
								 	   {1,5,2,9,4,7,0}},
							cache[][] = new int[7][7],
							board2[][]={{1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,1},
									   {1,1,1,1,1,1,2},
								 	   {1,1,1,1,1,2,0}};
	public static void main(String args[])
	{
		for(int i = 0 ; i < cache.length; i++)
		{
			for(int j = 0 ; j < cache[i].length; j++)
			{
				cache[i][j] = -1;
			}
		}
		System.out.println(jump(0,0));
		
	}
	public static int jump(int x, int y)
	{
		if(x >= n || y >= n)
		{
			return 0;
		}
		if(x == n-1 && y == n-1)
		{
			return 1;
		}
		int ret = cache[x][y];
		if(ret != -1)
		{
			return ret;
		}
		return ret = (jump(x+board2[x][y], y)!=0 || jump(x, y+board2[x][y])!=0)?1:0;
	}
}
