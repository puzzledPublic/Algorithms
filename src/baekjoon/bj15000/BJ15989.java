package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1, 2, 3 더하기 4
public class BJ15989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[10_001][4];	//dp[i][j] = 1,2,3의 합으로 i를 만들고 이를 오름차순으로 둘 때 마지막에 j로 끝나는 경우의 수.
		dp[0][1] = dp[1][1] = dp[2][1] = dp[2][2] = 1;
		for(int i = 3; i < dp.length; i++) {
			dp[i][1] = dp[i - 1][1];	//1로 끝난다면 이전도 1이어야 한다.
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];	//2로 끝난다면 이전은 1, 2로 끝나야 한다.
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];	//3으로 끝난다면 이전은 1, 2, 3으로 끝나야 한다.
		}

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());	
			bw.write((dp[N][1] + dp[N][2] + dp[N][3]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
