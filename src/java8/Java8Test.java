package java8;

import java.util.Scanner;
//색종이 문제 1438
public class Java8Test {

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		boolean paper[][] = new boolean[100][100];
		
		int num = input.nextInt();
		
		int position[][] = new int[num][2];
		
		for(int i = 0 ; i< num ; i++)
		{
			position[i][0] = input.nextInt();
			position[i][1] = input.nextInt();
		}
		input.close();
		for(int i = 0 ; i < num ; i++)
		{
			for(int j = position[i][0] ; j < position[i][0]+10; j++)
			{
				for(int k = position[i][1]; k < position[i][1]+10; k++)
				{
					paper[j][k] = true;
				}
			}
		}
		int sum=0;
		for(int i = 0 ; i<100;i++)
		{
			for(int j = 0 ; j < 100; j++)
			{
				if(paper[i][j] == true)
					{
						sum++;
					}
			}
		}
		
		System.out.println(sum);
		
		
	}
		
}