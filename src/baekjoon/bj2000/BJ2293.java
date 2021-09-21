package baekjoon.bj2000;

import java.util.Scanner;
//동전 1
public class BJ2293 {
	static int N, K;
	static int[] coins, DT2 = new int[10001];
	static int[][] DT = new int[101][10001];
	static int ans = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		coins = new int[N];
		
		for(int i = 0; i < N; i++) {
			coins[i] = input.nextInt();
		}
//		for(int i = 0; i < 101; i++) {
//			for(int j = 0; j < 10001; j++) {
//				DT[i][j] = -1;
//			}
//		}
//		System.out.println(solve(0, 0));
		System.out.println(solve3());
//		System.out.println(ans);
	}
	//완전탐색
	static void solve2(int n, int k) {
		if(k == K) {
			ans++;
			return;
		}
		if(n == N) {
			return;
		}
		int i = 0;
		while(coins[n] * i + k <= K) {
			solve(n + 1, coins[n] * i + k);
			i++;
		}
	}
	//메모이제이션? 적용
	static int solve(int n, int k) {
		if(k == K) {
			return 1;
		}
		if(n == N) {
			return 0;
		}
		if(DT[n][k] == -1) {
			DT[n][k] = 0;
			int i = 0;
			while(coins[n] * i + k <= K) {
				DT[n][k] += solve(n + 1, coins[n] * i + k);
				i++;
			}
		}
		return DT[n][k];
	}
	static int solve3() {
		DT2[0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = coins[i]; j <= K; j++) {
				DT2[j] += DT2[j - coins[i]];
			}
		}
		return DT2[K];
	}
}
