package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//2xn 타일링
public class BJ11726 {
	static int MOD = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		solve(N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, Writer w) throws IOException {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}
		w.write(dp[n] + "\n");
	}
}
