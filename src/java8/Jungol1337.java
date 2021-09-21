package java8;

import java.util.Scanner;

public class Jungol1337 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		snailTriangle(n);
	}

	public static void snailTriangle(int n) {
		int[][] arr = new int[n][n];
		int num = 0;
		int x=-1,y=-1;
		int m = n;
		
		while (m > 0) {
			for(int i = 0 ; i < m; i++){
					x++;
					y++;
					arr[x][y] = num++%10;
			}
			m--;
			for(int i = 0 ; i < m; i++){
				y--;
				arr[x][y] = num++%10;
			}
			m--;
			for(int i = 0 ; i < m; i++){
				x--;
				arr[x][y] = num++%10;
			}
			m--;
		}
		for(int i = 0 ; i < n;i++){
			for(int j= 0;j<i+1;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
}
