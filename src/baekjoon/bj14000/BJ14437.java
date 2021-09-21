package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//준오는 심술쟁이!!
public class BJ14437 {
	static int N, S;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = Integer.parseInt(br.readLine());
		String str = br.readLine();
		N = str.length();
		dp = new int[3001][3001];
		for(int i = 0; i < 3001; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		bw.write(solve(0, 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int s) {	//n번째 문자까지 s만큼 사용하여 바꿨을때 경우의 수
		if(n == N) {
			if(s == S) {
				return 1;
			}
			return 0;
		}
		
		if(s > S) {
			return 0;
		}
		
		if(dp[n][s] != -1) {
			return dp[n][s];
		}
		
		dp[n][s] = 0;
		for(int i = 0; i < 26; i++) {	//한 글자당 0~25번 바꿀 수 있다.
			dp[n][s] = (dp[n][s] + solve(n + 1, s + i)) % 1_000_000_007;
		}
		
		return dp[n][s];
	}
}
