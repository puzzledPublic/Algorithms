package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//점프 점프
public class BJ11060 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];	//N번째 자리에 도착할 수 있는 최소 점프 횟수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[0] = 0;	//맨 왼쪽에 위치해 있으므로 점프 횟수는 0
		
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {	//dp[i] = i이전 발판에서 i까지 점프뛸 수 있는 발판 j들 중 최소 점프 횟수
				if(j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j]) + 1;
				}
			}
		}
		
		bw.write((dp[N - 1] == Integer.MAX_VALUE ? "-1" : dp[N - 1]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
