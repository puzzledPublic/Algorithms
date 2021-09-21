package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1, 2, 3 더하기
public class BJ9095 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			count = 0;
			solve(Integer.parseInt(br.readLine()), 0);
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//모든 경우의 수
	static void solve(int n, int k) {
		if(k >= n) {
			if(k == n) {
				count++;
			}
			return;
		}
		for(int i = 1; i < 4; i++) {
			solve(n, k + i);
		}
	}
	//dp[n] = n을 만드는데 1, 2, 3을 이용하여 만드는 경우의 수
	//잘 살펴보면 n을 만드는데 n - 1을 만드는 각 경우들에 1을 더한것과 n - 2를 만드는 각 경우들에 2를 더한것 그리고 n - 3을 만드는 각 경우들에 3을 더한것들을 모두 모아보면
	//n을 만드는 모든 경우가 된다.
	static void solve2(int n) {
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		System.out.println(dp[n]);
	}
}
