package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//카드 구매하기 2
public class BJ16194 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] card = new int[N + 1];
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		//dp[i] = i개의 카드를 살 때 최소 구매 가격
		//      = min(dp[i - 개수] + card[개수])
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < i + 1; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + card[j]); 
			}
		}
		
		bw.write(dp[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
