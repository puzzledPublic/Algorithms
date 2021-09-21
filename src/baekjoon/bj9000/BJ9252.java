package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS2
//LCS(xm, yn) = 0 (if x.length = 0 or y.length = 0)
//			  = LCS(x(m-1), y(n-1)) + 1 (if xm == yn)
//			  = Max(LCS(x(m-1), yn), LCS(xm, y(n-1))) (if xm != yn)
public class BJ9252 {
	static int[][] dpp;
	static String s1, s2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
//		solve(s1, s2);
		
		int len1 = s1.length(), len2 = s2.length();
		dpp = new int[len1 + 1][len2 + 1];
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				dpp[i][j] = -1;
			}
		}
		System.out.println(solve2(len1, len2));
//		for(int i = 0; i <= len1; i++) {
//			for(int j = 0; j <= len2; j++) {
//				System.out.print((dpp[i][j] < 0 || dpp[i][j] > 10 ? dpp[i][j]: " " + dpp[i][j]) + " ");
//			}
//			System.out.println();
//		}
		System.out.println(backtrack(len1, len2));
		br.close();
	}
	//bottom up
	static void solve(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}
		for(int i = 0; i <= n; i++) {
			dp[0][i] = 0;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[m][n]);
	}
	//top down
	static int solve2(int len1, int len2) {
		if(len1 == 0 || len2 == 0) {
			return 0;
		}
		
		if(dpp[len1][len2] != -1) {
			return dpp[len1][len2];
		}
		
		if(s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
			dpp[len1][len2] = solve2(len1 - 1, len2 - 1) + 1;
		}else {
			dpp[len1][len2] = Math.max(solve2(len1 - 1, len2), solve2(len1, len2 - 1));
		}
		
		return dpp[len1][len2];
 		
	}
	//완성된 dp배열을 backtrack으로 LCS 문자열을 얻는다.
	static String backtrack(int len1, int len2) {
		if(len1 == 0 || len2 == 0) {
			return "";
		}else if(s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
			return backtrack(len1 - 1, len2 - 1) + s1.charAt(len1 - 1);
		}else {
			if(dpp[len1][len2 - 1] > dpp[len1 - 1][len2]) {
				return backtrack(len1, len2 - 1);
			}else {
				return backtrack(len1 - 1, len2);
			}
		}
	}
}
