package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//돌 게임 3
public class BJ9657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] dp = new boolean[1001];	//i개의 돌을 각 턴마다 1, 3, 4개 가져갈때 마지막 돌을 가져가는 사람(true = "SK", false = "CY")
		dp[0] = dp[1] = dp[3] = dp[4] = true;
		for(int i = 5; i <= N; i++) {
			dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
		}
		
		bw.write((dp[N] ? "SK" : "CY") + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
