package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//파스칼의 삼각형
public class BJ16395 {
	static int[][] dp = new int[31][31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		System.out.println(solve(n - 1, k - 1));
	}
	
	static int solve(int n, int k) {
		if(n == k || k == 0) {
			return dp[n][k] = 1;
		}
		if(k == 1) {
			return dp[n][k] = n;
		}
		if(dp[n][k] != 0) {
			return dp[n][k];
		}
		return dp[n][k] = solve(n - 1, k) + solve(n - 1, k - 1);
	}
}
