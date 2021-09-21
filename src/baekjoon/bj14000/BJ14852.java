package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타일 채우기3
public class BJ14852 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int MOD = 1_000_000_007;
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1_000_001];
		int[] sum = new int[1_000_001];
		
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		sum[2] = 7 * 2 + 2 * 2 + 1 * 2;
		
		//N = 3부터 특유의 모형이 2개씩 존재한다.
		//dp[i] = 2 * dp[i - 1] + 3 * dp[i - 2] + 2 * dp[i - 3] + ... 2 * dp[0]
		//dp[i] = 2 * (dp[i - 1] + dp[i - 2] + dp[i - 3] + ... dp[0]) + dp[i - 2]가 된다.
		//계산을 빠르게 하기위해 누적합을 구한다. sum[i] = 2 * (dp[i] + dp[i - 1] + dp[i - 2] + ... dp[0])  
		for(int i = 3; i <= N; i++) {
			dp[i] = (sum[i - 1] + dp[i - 2]) % MOD;
			sum[i] = (sum[i - 1] + (dp[i] * 2) % MOD) % MOD;
		}
		
		bw.write(dp[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
