package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//다이나믹이 뭐예요?
public class BJ14494 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int MOD = 1_000_000_007;
		int[][] dp = new int[N + 1][M + 1];
		
		dp[0][0] = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = (((dp[i - 1][j] + dp[i][j - 1]) % MOD) + dp[i - 1][j - 1]) % MOD;
			}
		}
		
		bw.write(dp[N][M] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
