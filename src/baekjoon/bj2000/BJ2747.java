package baekjoon.bj2000;

import java.util.Scanner;

//피보나치 수 1
public class BJ2747 {
	static int[] DP = new int[46];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < DP.length; i++) {
			DP[i] = -1;
		}
		System.out.println(solve(input.nextInt()));
	}
	static int solve(int n) {
		if(n <= 1) {
			return DP[n] = n;
		}
		return DP[n] != -1 ? DP[n] : (DP[n] = solve(n - 1) + solve(n - 2));
	}
}
