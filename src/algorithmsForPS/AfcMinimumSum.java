package algorithmsForPS;

import java.util.Scanner;

public class AfcMinimumSum {
	static int N = 4;
	static int arr[][] = {
		{1, 5, 3, 2},
		{2, 4, 7, 6},
		{5, 3, 5, 1},
		{4, 9, 3, 8}
	};
	static int min = 987654321;
	static int chk[] = new int[11];
	public static void main(String[] args) {
		/*
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		*/
		solve(0, 0);
		
		System.out.println(min);
	}
	
	static void solve(int n, int sum) {
		if(n == N) {
			if(min > sum) {
				min = sum;
			}
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(chk[i] != 1) {
				chk[i] = 1;
				solve(n + 1, sum + arr[n][i]);
				chk[i] = 0;
			}
		}
	}
}
