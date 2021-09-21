package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//카우버거 알바생
public class BJ17208 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[M + 1][K + 1];
		int[][] orders = new int[N + 1][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			orders[i][0] = Integer.parseInt(st.nextToken());
			orders[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp[M][K] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= M; j++) {
				for(int k = 0; k <= K; k++) {
					if(j - orders[i][0] >= 0 && k - orders[i][1] >= 0 && dp[j][k] > 0) {
						dp[j - orders[i][0]][k - orders[i][1]] = Math.max(dp[j][k] + 1, dp[j - orders[i][0]][k - orders[i][1]]);
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i <= M; i++) {
			for(int j = 0; j <= K; j++) {
				if(result < dp[i][j]) {
					result = dp[i][j] - 1;
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}

/* 3차원 DP를 사용해서 느림.. 
public class BJ17208 {
	static int N, M, K;
	static int[][][] dp;
	static int[][] orders;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[M + 1][K + 1][N + 1];
		orders = new int[N + 1][2];
		
		for(int i = 0; i <= M; i++) {
			for(int j = 0; j <= K; j++) {
				for(int k = 0; k <= N; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			orders[i][0] = Integer.parseInt(st.nextToken());
			orders[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		bw.write(solve(M, K, 0) + "\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve(int M, int K, int order) {
		if(order == N) {
			return 0;
		}
		
		if(dp[M][K][order] != -1) {
			return dp[M][K][order];
		}
		
		dp[M][K][order] = 0;
		for(int i = order + 1; i <= N; i++) {
			if(M - orders[i][0] >= 0 && K - orders[i][1] >= 0) {
				dp[M][K][order] = Math.max(dp[M][K][order], solve(M - orders[i][0], K - orders[i][1], i) + 1);
			}
		}
		
		return dp[M][K][order];
	}
}*/

