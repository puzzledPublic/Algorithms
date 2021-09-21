package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//1로 만들기 2
public class BJ12852 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
		
		bw.write(dp[N] + "\n");
		
		bw.write(N + " ");
		while(N > 1) {
			int a = dp[N - 1];
			int b = N % 3 == 0 ? dp[N / 3] : Integer.MAX_VALUE;
			int c = N % 2 == 0 ? dp[N / 2] : Integer.MAX_VALUE;
			if(a >= c && b >= c) {
				N /= 2;
			}else if(a >= b && c >= b) {
				N /= 3;
			}else if(b >= a && c >= a) {
				N -= 1;
			}
			bw.write(N + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
