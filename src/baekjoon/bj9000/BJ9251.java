package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS (최장 공통 부분 수열)
public class BJ9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine(), br.readLine());
	}
	//LCS(xm, yn) = 0 (x==0 or y==0)
	//			  = LCS(x(m-1), y(n-1)) + 1 (xm == yn)
	//			  = Max(LCS(x(m-1), yn), LCS(xm, y(n-1))) (xm != yn)
	static void solve(String a, String b) {
		int m = a.length(), n = b.length();
		int[][] DP = new int[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) {
			DP[i][0] = 0;
		}
		for(int i = 0; i <= n; i++) {
			DP[0][i] = 0;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				}else {
					DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
				}
			}
		}
		System.out.println(DP[m][n]);
	}
}
