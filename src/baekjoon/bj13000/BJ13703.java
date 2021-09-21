package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//물벼룩의 생존확률
public class BJ13703 {
	static int K, N;
	static long[][] dp;	//현재 K위치이고 N초일때 생존 가능한 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new long[K + N + 1][N + 1];	//(0 ~ K + N)까지의 범위로 움직일 수 있다.
		
		for(int i = 0; i < K + N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				dp[i][j] = -1;
			}
		}
		
		bw.write(solve(K, 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int k, int n) {
		if(k == 0) {	//현재 위치(k)가 수면(0)이라면 생존 불가.
			return dp[k][n] = 0;
		}
		if(n == N) {	//시간이 모두 지났으면 생존.
			return dp[k][n] = 1;
		}
		if(dp[k][n] != -1) {	//Memoization
			return dp[k][n];
		}
		return dp[k][n] = solve(k + 1, n + 1) + solve(k - 1, n + 1);
	}
}
