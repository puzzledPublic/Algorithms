package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 긴 감소하는 부분 순열
public class BJ11722 {
	static int N;
	static int[] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, solve(i));
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int start) {
		if(dp[start] != 0) {
			return dp[start];
		}
		dp[start] = 1;
		for(int i = start + 1; i < N; i++) {
			if(arr[start] > arr[i]) {
				dp[start] = Math.max(dp[start], solve(i) + 1);
			}
		}
		return dp[start];
	}
}
