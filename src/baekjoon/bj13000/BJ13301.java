package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타일 장식물
public class BJ13301 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] dp = new long[81];
		dp[1] = dp[2] = 1;
		for(int i = 3; i < 81; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int N = Integer.parseInt(br.readLine());
		bw.write((N == 1 ? 4 : ((dp[N] + dp[N - 1]) * 2L + (dp[N - 1] + dp[N - 2]) * 2L)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
