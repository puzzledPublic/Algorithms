package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//01타일
public class BJ1904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()), MOD = 15746;
		int[] DP = new int[2];
		DP[0] = DP[1] = 1;
		for(int i = 2; i < N + 1; i++) {
			DP[i % 2] = (DP[(i - 1) % 2] + DP[(i - 2) % 2]) % MOD;	//dp[i] = i번째 수열을 만들때 가능한 가지수. 현재 i위치에 00과 1을 채울 수 있으므로 dp[i] = dp[i-2] + dp[i-1]이 된다.
		}
		bw.write(DP[N % 2] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
