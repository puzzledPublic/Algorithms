package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1, 2, 3 더하기 5
public class BJ15990 {
	static final int MOD = 1_000_000_009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//dp[i][j] = 1, 2, 3으로 i의 숫자를 만드는 수열(같은 숫자는 연속하지 않는 수열)을 나열할때 맨 뒤에오는 숫자가 j인 경우의 수
		int[][] dp = new int[100_001][4];
		dp[0][1] = dp[1][1] = dp[2][2] = 1;
		for(int i = 3; i < dp.length; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;	//1로 끝난다면 이전 숫자는 1이 아니어야 한다.
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;	//2로 끝난다면 이전 숫자는 2가 아니어야 한다.
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD; //3으로 끝난다면 이전 숫자는 3이 아니어야 한다.
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = (((dp[N][1] + dp[N][2]) % MOD) + dp[N][3]) % MOD;
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
