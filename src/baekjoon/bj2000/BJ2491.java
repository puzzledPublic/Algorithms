package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수열
public class BJ2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		int[][] dp = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 1;
		dp[0][0] = dp[0][1] = 1;
		for(int i = 1; i < N; i++) {
			if(arr[i - 1] <= arr[i]) {	//오름차순 중 가장 긴 길이
				dp[i][0] = dp[i - 1][0] + 1;
			}else {
				dp[i][0] = 1;
			}
			if(arr[i - 1] >= arr[i]) {	//내림차순 중 가장 긴 길이
				dp[i][1] = dp[i - 1][1] + 1;
			}else {
				dp[i][1] = 1;
			}
			result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
