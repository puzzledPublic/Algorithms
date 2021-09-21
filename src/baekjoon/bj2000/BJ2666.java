package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//벽장문의 이동
public class BJ2666 {
	static int N, M, ld, rd;
	static int[] visit;	//열 문의 위치 순서
	static int[][][] dp;	//dp[i][j][k] = visit[k]까지 열었고 현재 열린 문 상태가 i, j일때 최소 움직인 횟수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ld = Integer.parseInt(st.nextToken());
		rd = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		visit = new int[M + 1];		
		dp = new int[N + 1][N + 1][M + 1];
		
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				for(int k = 0; k < M + 1; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			visit[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(solve(ld, rd, 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int d1, int d2, int m) {
		if(m == M + 1) {	//M개의 문을 모두 열었음.
			return 0;
		}
		
		if(dp[d1][d2][m] != -1) {
			return dp[d1][d2][m];
		}
		//Min(열린 d1 문을 visit[m]으로 옮길 때, 열린 d2문을 visit[m]으로 옮길 때)
		return dp[d1][d2][m] = Math.min(Math.abs(d1 - visit[m]) + solve(visit[m], d2, m + 1) , Math.abs(d2 - visit[m]) + solve(d1, visit[m], m + 1));
	}
}
