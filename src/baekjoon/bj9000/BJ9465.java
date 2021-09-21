package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//스티커
public class BJ9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			int[][] dp = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[0][1];
			for(int j = 1; j < N; j++) {	//j번째 열의 위 또는 아래 스티커까지 골랐을때의 최대값
				dp[j][0] = Math.max(dp[j - 1][0], dp[j - 1][1] + arr[j][0]);	//j번째 열의 위 스티커를 고르지 않은 경우, 고른 경우 중 최대값이 j열 위 스티커까지 골랐을때의 최대값이다.
				dp[j][1] = Math.max(dp[j - 1][1], dp[j - 1][0] + arr[j][1]);
			}
			bw.write((Math.max(dp[N - 1][0], dp[N - 1][1])) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
