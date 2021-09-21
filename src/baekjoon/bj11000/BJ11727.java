package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2xn 타일링 2
public class BJ11727 {
	static int M = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		bw.write(solve(dp) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//동적계획법
	//dp[i] = 2xi의 사각형을 2x1, 2x2로 채우는 경우의 수
	static int solve(int[] dp) {
		dp[0] = dp[1] = 1;
		for(int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] % M + (2 * dp[i - 2]) % M) % M;
		}
		return dp[dp.length - 1];
	}
}
