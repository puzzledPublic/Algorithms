package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//평범한 배낭
public class BJ12865 {
	static int N, K;
	static int[] product;
	static int[] value;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		product = new int[N];
		value = new int[N];
		dp = new int[N][K + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			product[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		
		bw.write(solve(0, 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int k) {
		if(n == N) {
			return 0;
		}
		if(dp[n][k] != -1) {
			return dp[n][k];
		}
		
		dp[n][k] = solve(n + 1, k);
		if(k + product[n] <= K) {
			dp[n][k] = Math.max(dp[n][k], solve(n + 1, k + product[n]) + value[n]);
		}
		return dp[n][k];
	}
}
