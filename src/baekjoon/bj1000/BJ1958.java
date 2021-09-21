package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//LCS 3
public class BJ1958 {
	static int[][][] dp;	//dp[i][j][k] = A[i], B[i], C[i]까지의 LCS 길이
	static String A, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		A = br.readLine();
		B = br.readLine();
		C = br.readLine();
		
		int aLen = A.length();
		int bLen = B.length();
		int cLen = C.length();
		
		dp = new int[aLen + 1][bLen + 1][cLen + 1];
		for(int i = 0; i <= aLen; i++) {
			for(int j = 0; j <= bLen; j++) {
				for(int k = 0; k <= cLen; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		bw.write(solve(aLen - 1, bLen - 1, cLen - 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int a, int b, int c) {
		if(a < 0 || b < 0 || c < 0) {
			return 0;
		}
		
		if(dp[a][b][c] != -1) {
			return dp[a][b][c];
		}
		
		char cha = A.charAt(a);
		char chb = B.charAt(b);
		char chc = C.charAt(c);
		
		if(cha == chb && chb == chc) {	//A[a] == B[b] == C[c]인 경우.
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a - 1, b - 1, c - 1) + 1);
		}else {	//그 외의 경우
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a, b, c - 1));
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a - 1, b , c));
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a, b - 1, c));
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a - 1, b - 1, c));
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a - 1, b, c - 1));
			dp[a][b][c] = Math.max(dp[a][b][c], solve(a, b - 1, c - 1));
		}
		
		return dp[a][b][c];
	}
}
