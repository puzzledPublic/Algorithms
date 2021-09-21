package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Acka
public class BJ12996 {
	static int S, D, K, H;
	static int MOD = 1_000_000_007;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dp = new int[S + 1][D + 1][K + 1][H + 1];
		
		for(int i = 0; i <= S; i++) {
			for(int j = 0; j <= D; j++) {
				for(int k = 0; k <= K; k++) {
					for(int h = 0; h <= H; h++) {
						dp[i][j][k][h] = -1;
					}
				}
			}
		}
		
		bw.write(solve(0, D, K, H) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int s, int d, int k, int h) {	//s개의 곡을 썼고 각각 d, k, h개 곡을 쓸 수 있을때 경우의 수
		if(s == S) {
			if(d == 0 && k == 0 && h == 0) {
				return dp[s][d][k][h] = 1;
			}
			return dp[s][d][k][h] = 0;
		}
		
		if(dp[s][d][k][h] != -1) {
			return dp[s][d][k][h];
		}
		
		dp[s][d][k][h] = 0;
		
		if(d > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d - 1, k, h)) % MOD;
		}
		if(k > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d, k - 1, h)) % MOD;
		}
		if(h > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d, k, h - 1)) % MOD;
		}
		if(d > 0 && k > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d - 1, k - 1, h)) % MOD;
		}
		if(d > 0 && h > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d - 1, k, h - 1)) % MOD;
		}
		if(k > 0 && h > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d, k - 1, h - 1)) % MOD;
		}
		if(d > 0 && k > 0 && h > 0) {
			dp[s][d][k][h] = (dp[s][d][k][h] + solve(s + 1, d - 1, k - 1, h - 1)) % MOD;
		}
		return dp[s][d][k][h];
	}
}
