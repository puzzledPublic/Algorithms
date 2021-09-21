package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이친수
public class BJ2193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][2];	//i번째 자리에 숫자가 j일떄의 이친수 개수
		dp[1][1] = 1;	//첫번째 자리에는 0이 올 수 없으므로 dp[1][0] = 0이고 dp[1][1] = 1
//		dp[2][0] = 1;
		
		for(int i = 2; i < N + 1; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];	//i번째 자리에 0이 올 경우 i - 1번째 자리에는 0 또는 1이 올 수 있다.
			dp[i][1] = dp[i - 2][0] + dp[i - 2][1]; //i번쨰 자리에 1이 올 경우 1이 연속되면 안되므로 i - 1번째 자리는 0이 와야하고 i - 2번쨰 자리에는 0 또는 1이 올 수 있다.
		}
		
		System.out.println(dp[N][0] + dp[N][1]);
	}
}
