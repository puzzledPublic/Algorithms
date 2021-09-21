package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//앱
public class BJ7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][N * 100 + 1];	//i번째 까지 골랐고 현재 비활성 비용이 j일때 해제될 수 있는 최대 바이트 수
		
		dp[0][cost[0]] = memory[0];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N * 100 + 1; j++) {
				if(j - cost[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]);	//현재 i를 비활성 하거나
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);	//비활성 하지 않거나
			}
		}
		
		int result = 0;
		for(int i = 0; i < N * 100 + 1; i++) {
			if(dp[N - 1][i] >= M) {	//최초로 M보다 클 때 비용이 최소
				result = i;
				break;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
