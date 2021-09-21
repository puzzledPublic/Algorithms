package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//삼각수의 합
public class BJ2721 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[301];
		
		int sum = 1;
		for(int i = 1; i <= 300; i++) {
			sum += i + 1;
			dp[i] = dp[i - 1] + (i * sum);
		}
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
