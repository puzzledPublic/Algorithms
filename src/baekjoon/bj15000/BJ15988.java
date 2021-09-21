package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1, 2, 3 더하기 3
public class BJ15988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int MOD = 1_000_000_009;
		int[] dp = new int[1_000_001];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < dp.length; i++) {
			dp[i] = (((dp[i - 1] + dp[i - 2]) % MOD) + dp[i - 3]) % MOD;
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
