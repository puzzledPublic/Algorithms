package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//최소 편집(최소 편집 거리 문제 Minimum Edit Distance)
public class BJ15483 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		
		for(int i = 0; i < A.length() + 1; i++) {	//공집합과 A의 문자열에 대한 최소 편집
			dp[i][0] = i;
		}
		for(int j = 0; j < B.length() + 1; j++) {	//공집합과 B의 문자열에 대한 최소 편집
			dp[0][j] = j;
		}
		
		for(int i = 1; i < A.length() + 1; i++) {
			for(int j = 1; j < B.length() + 1; j++) {
				if(A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		
		bw.write(dp[A.length()][B.length()] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
