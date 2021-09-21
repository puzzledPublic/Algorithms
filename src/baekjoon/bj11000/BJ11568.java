package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//민균이의 계략 (LIS)
public class BJ11568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		//O(N^2)
		int max = 1;
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(cards[j] < cards[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
