package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//외판원 순회
public class BJ2098 {
	static int N;
	static int[][] cost;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp = new int[N][1 << 16];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j = 0; j < N; j++) {
			Arrays.fill(dp[j], Integer.MAX_VALUE);
		}
		
		bw.write(solve(0, 1, 0) + "\n");	
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int k, int s) {	//현재 n정점을 방문중이고 방문상태가 k일때 s에 도착하는 최소 비용.
		if(k == ((1 << N) - 1)) {	//모든 정점(각비트)가 방문(1)했고
			if(cost[n][s] != 0) {	//n에서 s로 돌아갈 수 있다면.
				return dp[n][k] = cost[n][s];
			}
			return dp[n][k];
		}
		
		if(dp[n][k] != Integer.MAX_VALUE) {
			return dp[n][k];
		}
		
		for(int i = 0; i < N; i++) {
			if(cost[n][i] != 0 && (k & (1 << i)) == 0) {	//n 정점에서 i 정점으로 갈 수 있고 i 정점을 아직 방문하지 않은 경우
				int t = solve(i, (k | (1 << i)), s);
				if(t != Integer.MAX_VALUE) {
					dp[n][k] = Math.min(dp[n][k], t + cost[n][i]);
				}
			}
		}
		
		return dp[n][k];
	}
}
