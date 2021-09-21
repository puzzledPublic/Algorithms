package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//괄호
//카탈란 수로 풀 수 있다고 한다.
public class BJ10422 {
	static long mod = 1_000_000_007L;
	static long[] dp = new long[5001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		Arrays.fill(dp, -1);
		solve(5000);
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			if (N % 2 == 0) {
				bw.write(solve(N) + "\n");
			} else {
				bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static long solve(int n) {
		if (n == 0)
			return 1;
		if (dp[n] >= 0)
			return dp[n];
		dp[n] = 0;
		for (int i = 2; i <= n; i += 2) {
			dp[n] += (solve(i - 2) * solve(n - i));	//'()' 기준 왼쪽, 오른쪽 길이
			dp[n] %= mod;
		}
		return dp[n];
	}
}
