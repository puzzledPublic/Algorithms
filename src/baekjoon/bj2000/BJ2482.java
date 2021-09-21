package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//색상환
public class BJ2482 {
	static int N, K;
	static int[][][] dp;
	static int MOD = 1_000_000_003;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		dp = new int[N][K + 1][2];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K + 1; j++) {
				dp[i][j][0] = dp[i][j][1] = -1;
			}
		}
		int a = solve(0, 0, 0, 0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K + 1; j++) {
				dp[i][j][0] = dp[i][j][1] = -1;
			}
		}
		
		int b = solve(0, 1, 1, 1);
		
		bw.write(((a + b) % MOD) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int k, int s, int in) {	//현재까지 k개 선택했고 현재 n번 색을 s상태(0=>안고름, 1=>고름)일때 경우의 수
		if(k == K) {
			return dp[n][k][s] = 1;
		}
		//in == 1 => 첫번째를 고른 경우 n - 1은 못고르므로 n - 2까지, in == 0 => 첫번째를 고르지 않은 경우 n - 1까지
		if((in == 1 && n == N - 2) || n == N - 1) {
			return dp[n][k][s] = 0;
		}
		
		if(dp[n][k][s] != -1) {
			return dp[n][k][s];
		}
		
		if(s == 0) {
			return dp[n][k][s] = (solve(n + 1, k, 0, in) + solve(n + 1, k + 1, 1, in)) % MOD; 
		}else {
			return dp[n][k][s] = solve(n + 1, k, 0, in) % MOD;
		}
	}
}
