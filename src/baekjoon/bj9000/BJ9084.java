package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//동전 (TODO::1차원으로도 풀 수 있음- 공부)
public class BJ9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] coins = new int[21];
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
						
			int M = Integer.parseInt(br.readLine());
			
			int[][] money = new int[N + 1][M + 1];	//dp[i][j] = i개 종류의 동전으로 j원을 만드는 경우의 수
			
			for(int i = 1; i <= N; i++) {	//초기값.
				money[i][0] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(j - coins[i] >= 0) {
						money[i][j] += money[i][j - coins[i]];	//i번째 동전으로 만드는 경우의 수
					}
					money[i][j] += money[i - 1][j];	//i-1개 종류로 만드는 경우의 수
				}
			}
			
			bw.write(money[N][M] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
