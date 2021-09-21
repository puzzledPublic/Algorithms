package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//줄어들지 않아
public class BJ2688 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[][] dp = new long[65][10];	//dp[i][j] = i번째 숫자가 j일때 줄어들지 않는 수의 개수
		
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < 65; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long count = 0;
			for(int i = 0; i < 10; i++) {
				count += dp[N - 1][i];
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
