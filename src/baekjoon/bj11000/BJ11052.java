package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//붕어빵
public class BJ11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N + 1], dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(solve(dp, cost, N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//동적계획법
	//dp[i] = 붕어빵이 i개 남았을때 얻을 수 있는 최대 수익
	static int solve(int[] dp, int[] cost, int N) {
		dp[1] = cost[1];
		for(int i = 2; i < N + 1; i++) {
			for(int j = 1; j <= i; j++) {	//붕어빵이 i개 남았을때 각각 1개부터 i개까지 파는 수익 중 최대 수익을 담는다.
				dp[i] = Math.max(dp[i], dp[i - j] + cost[j]);
			}
		}
		return dp[N];
	}
}
