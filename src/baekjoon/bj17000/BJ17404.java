package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//RGB거리 2
public class BJ17404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] home = new int[N][3];
		int[][] dp = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {	//첫번째 집의 색깔을 정한다. (k => 0 == R, 1 == G, 2 == B)
			dp[0][0] = dp[0][1] = dp[0][2] = 987654321;
			dp[0][k] = home[0][k];	//k 색을 칠한다.
			for(int i = 1; i < N; i++) {	//나머지 집들에 대해 DP로 N번째 집까지 칠하는 최소 비용을 구한다.
				for(int j = 0; j < 3; j++) {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + home[i][j];
				}
			}
			//첫번째 집을 k 색으로 칠한 경우 마지막 집은 (k+1)%3 또는 (k+2)%3 색으로 칠해야한다.
			result = Math.min(result, Math.min(dp[N - 1][(k + 1) % 3], dp[N - 1][(k + 2) % 3]));
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
