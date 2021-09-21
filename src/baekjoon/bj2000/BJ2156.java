package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
public class BJ2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1];
		int[] grapes = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			grapes[i] = Integer.parseInt(br.readLine());
		}
		solve(N, grapes, DP);
	}
	static void solve(int n, int[] grapes, int[] dp) {
		dp[1] = grapes[1];
		if(n > 1) {	//입력이 한개뿐이면 런타임 에러가 날 수 있으므로 처리
			dp[2] = grapes[1] + grapes[2];
			for(int i = 3; i <= n; i++) {
				//dp[i] = max(
				//	dp[i - 1](i번째를 안먹은 경우), 
				//	dp[i - 2] + grapes[i](i-2까지 먹고 i번째를 먹은 경우)
				//  dp[i - 3] + grapes[i - 1] + grapes[i](i, i-1번째는 먹고 i-2를 안먹은 경우))
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + grapes[i - 1]) + grapes[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
