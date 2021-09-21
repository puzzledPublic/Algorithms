package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//팰린드롬 분할
public class BJ1509 {
	static boolean[][] palin;
	static int[] dp;
	static String str;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str = br.readLine();
		len = str.length();
		palin = new boolean[len][len];	//palin[i][j] = i~j까지 문자열이 팰린드롬인가?
		dp = new int[len + 1];	//dp[i] = i번째 문자부터 가능한 최소 팰린드롬 분할 수
		
		for(int i = 0; i < len; i++) {
			palin[i][i] = true;
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 1; i < len; i++) {	//문자열 길이가 (i+1)
			for(int j = 0; j < len - i; j++) {	//j번째 문자부터
				if(i == 1 && str.charAt(j) == str.charAt(j + i)) {	//길이가 2인 경우
					palin[j][j + i] = true;
				}else if(palin[j + 1][j + i - 1] && str.charAt(j) == str.charAt(j + i)) {	//길이가 3이상인 경우.
					palin[j][j + i] = true;
				}
			}
		}
		
		bw.write(solve(0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int s) {
		if(s == len) {
			return dp[s] = 0;
		}
		
		if(dp[s] != Integer.MAX_VALUE) {
			return dp[s];
		}
		
		for(int i = s; i < len; i++) {
			if(palin[s][i]) {	//s~i까지 팰린드롬이고 (i+1)부터 가능한 최소 팰린드롬 분할 수 탐색.
				dp[s] = Math.min(dp[s], solve(i + 1) + 1);
			}
		}
		
		return dp[s];
	}
}
