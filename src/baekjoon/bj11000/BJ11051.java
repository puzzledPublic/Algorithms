package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이항 계수 2
public class BJ11051 {
	static int MOD = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}
	static void solve(int n, int k) {
		int[][] DP = new int[n + 1][n + 1];
		for(int i = 0; i < n + 1; i++) {
			DP[i][0] = 1;
			DP[i][1] = i;
			DP[i][i] = 1;
		}
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < k + 1; j++) {
				DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j]) % MOD;
			}
		}
		System.out.println(DP[n][k]);
	}
}
