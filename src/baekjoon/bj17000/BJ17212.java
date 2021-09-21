package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//달나라 토끼를 위한 구매대금 지불 도우미
public class BJ17212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];	//금액이 i일때 낼 수 있는 동전의 최소 개수.
		Arrays.fill(dp, Integer.MAX_VALUE);
		int[] coins = {1, 2, 5, 7};
		
		dp[0] = 0;
		for(int i = 1; i <= N; i++) {	//i일때
			for(int j = 0; j < 4; j++) {	//min(i-1, i-2, i-5, i-7) + 1 => i일때 최소 동전 사용 개수
				if(i - coins[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		
		bw.write(dp[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
