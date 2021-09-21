package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//진우의 달 여행 (Large)
public class BJ17485 {
	static int[][] map;
	static int[][][] dp;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M][4];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = Integer.MAX_VALUE;
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {	//map[0][0] ~ map[0][M-1]에서 출발 가능
			result = Math.min(result, solve(0, i, 0));
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//k = 1(왼쪽아래), 2(아래), 3(오른쪽아래)
	static int solve(int n, int m, int k) {	//map[n][m]에 k방향으로 왔을때 소비하는 최소 연료
		if(n == N) {
			return 0;
		}
		
		if(dp[n][m][k] != Integer.MAX_VALUE) {
			return dp[n][m][k];
		}
		
		//해당 방향으로 두번 연속 가면 안된다.
		if(m - 1 >= 0 && k != 1) {
			dp[n][m][k] = Math.min(dp[n][m][k], solve(n + 1, m - 1, 1) + map[n][m]);
		}
		if(k != 2) {
			dp[n][m][k] = Math.min(dp[n][m][k], solve(n + 1, m, 2) + map[n][m]);
		}
		if(m + 1 < M && k != 3) {
			dp[n][m][k] = Math.min(dp[n][m][k], solve(n + 1, m + 1, 3) + map[n][m]);
		}
		return dp[n][m][k];
	}
}