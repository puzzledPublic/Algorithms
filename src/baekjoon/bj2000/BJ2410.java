package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2의 멱수의 합
public class BJ2410 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][20];
		int[] sq = new int[21];
		for (int i = 0; i < 21; i++) {
			sq[i] = (int) Math.pow(2, i);
		}

		dp[0][0] = dp[1][0] = 1;
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; i - sq[j] >= 0; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i - sq[j]][k]) % 1_000_000_000;
				}
			}
		}

		int[] dp2 = new int[N + 1];
		for (int i = 0; i < 20; i++) {

			if (N < sq[i])
				break;
			dp2[sq[i]] = (dp2[sq[i]] + 1) % 1_000_000_000;
			for (int j = 1; j + sq[i] <= N; j++) {
				dp2[j + sq[i]] = (dp2[j + sq[i]] + dp2[j]) % 1_000_000_000;
			}
		}

		bw.write(dp2[N] + "\n");

		int sum = 0;
		for (int i = 0; i < 20; i++) {
			sum = (sum + dp[N][i]) % 1_000_000_000;
		}

		bw.write(sum + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
