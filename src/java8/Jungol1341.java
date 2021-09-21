package java8;

import java.util.Scanner;

public class Jungol1341 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int s,e,cnt=0;
		s = input.nextInt();
		e = input.nextInt();
		if(s>e)
		{
			for(int i = s; i>=e; i--)
			{
				for(int k = 1; k <=9; k++)
				{
					String j = i*k<10 ? " "+i*k:""+i*k;
					System.out.print(i+" * "+k+" = "+j+"   ");
					cnt++;
					if(cnt%3==0)
					{
						System.out.println();
					}
				}
				System.out.println();
			}
		}
		else
		{
			for(int i = s; i<=e; i++)
			{
				for(int k = 1; k <=9; k++)
				{
					String j = i*k<10 ? " "+i*k:""+i*k;
					System.out.print(i+" * "+k+" = "+j+"   ");
					cnt++;
					if(cnt%3==0)
					{
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}
}
