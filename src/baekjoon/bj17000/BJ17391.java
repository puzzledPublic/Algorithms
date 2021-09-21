package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//무한부스터
public class BJ17391 {
	static int[][] map;
	static int[][] dp;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bw.write(solve(0, 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int solve(int n, int m) {	//(n, m)에 도착할때 지나온 격자의 최소 개수
		if(n == N - 1 && m == M - 1) {
			return dp[n][m] = 0;
		}
		
		if(dp[n][m] != Integer.MAX_VALUE) {	//Memoization
			return dp[n][m];
		}
		
		int jump = map[n][m];	//(n, m)에서 얻는 부스터 개수
		
		int nn = n, nm = m;
		for(int i = 0; i < jump; i++) {	//오른쪽으로 1~jump개를 써서 갈 수 있다.
			nm += 1;
			if(0 <= nm && nm < M) {
				dp[n][m] = Math.min(dp[n][m], solve(n, nm) + 1);
			}
		}
		
		nn = n;
		nm = m;
		
		for(int i = 0; i < jump; i++) {	//아래쪽으로 1~jump개를 써서 갈 수 있다.
			nn += 1;
			if(0 <= nn && nn < N) {
				dp[n][m] = Math.min(dp[n][m], solve(nn, m) + 1);
			}
		}
		
		return dp[n][m];
	}
}
