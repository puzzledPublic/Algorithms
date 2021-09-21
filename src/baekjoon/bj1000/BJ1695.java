package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//팰린드롬 만들기
public class BJ1695 {
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		bw.write(solve(0, N - 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static int solve(int l, int r) {	//l ~ r 수열에서 팰린드롬을 만들때 끼워넣는 숫자의 최소 개수
		if(r - l <= 1) {	//차이가 1이하고
			if(arr[l] == arr[r]) {	//같은 숫자면 팰린드롬 만들 수 있게 끼워넣는 숫자 개수는 0개
				return dp[l][r] = 0;
			}
			return dp[l][r] = 1;	//다른 숫자면 팰린드롬 만들 수 있게 끼워넣는 숫자 개수는 1개
		}
		
		if(dp[l][r] != Integer.MAX_VALUE) {
			return dp[l][r];
		}
		
		if(arr[l] == arr[r]) {
			return dp[l][r] = solve(l + 1, r - 1);
		}
		
		return dp[l][r] = Math.min(solve(l + 1, r), solve(l, r - 1)) + 1;
	}
}
