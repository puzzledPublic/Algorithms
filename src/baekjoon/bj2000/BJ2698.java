package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//인접한 비트의 개수
public class BJ2698 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][][] dp = new int[101][101][2];	//dp[N][K][B] = 길이가 N이고 인접한 비트 개수가 K개이며 마지막 비트(B)가 0 or 1인 비트 수열의 개수
		
		dp[1][0][0] = dp[1][0][1] = 1;
		for(int i = 2; i < 101; i++) {	//길이가 i이고 인접한 비트 개수가 0개인 개수들을 구한다.
			dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1];
			dp[i][0][1] = dp[i - 1][0][0];
		}
		
		dp[2][1][1] = 1;
		for(int i = 3; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				//마지막 비트가 0인 경우 i-1길이의 인접한 비트 개수 j를 가진 비트 수열들의 개수.
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				//마지막 비트가 1인 경우 (i-1길이의 인접한 비트 개수 j를 가지고 마지막 비트가 0인 비트 수열 개수) + (i-1길이의 인접한 비트 개수 j-1개를 가지고 마지막 비트가 1인 비트 수열 개수)
				dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			bw.write((dp[N][K][0] + dp[N][K][1]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
