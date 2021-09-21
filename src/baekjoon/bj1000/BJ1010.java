package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//다리 놓기
public class BJ1010 {
	static int N, M;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M + 1][M + 1];
			for(int j = 0; j < M + 1; j++) {
				dp[j][1] = j;
				dp[j][0] = dp[j][j] = 1;
			}
			bw.write(solve2(dp) + "\n");
			
			/*
			//solve1()..
			dp = new int[N][M];
			int result = 0;
			for(int j = 0; j < M; j++) {
				result += solve(0, j);
			}
			bw.write(result + "\n");*/
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//생각해보면 M개의 다리에서 N개를 뽑는 경우의 수와 같다. 즉 mCn이 답이된다.
	//dp[i][j] = i개에서 j개를 뽑는 경우의 수
	//dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] (i개에서 한개를 뽑는 경우 + 뽑지 않는 경우)
	static int solve2(int[][] dp) {
		for(int i = 2; i < M + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return dp[M][N];
	}
	
	//완전탐색 + 메모이제이션( N이 클수록 시간이 걸림) -> 시간초과
	static int solve(int start, int connect) {
		if(start == N - 1) {
			return dp[start][connect] = 1;
		}
		if(dp[start][connect] != 0) {
			return dp[start][connect];
		}
		int result = 0;
		for(int i = connect + 1; i < M; i++) {
			result += solve(start + 1, i);
		}
		return dp[start][connect] = result;
	}
}
