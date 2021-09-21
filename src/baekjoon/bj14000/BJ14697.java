package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//방 배정하기
public class BJ14697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[4];
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] dp = new boolean[301];
		
		dp[arr[0]] = dp[arr[1]] = dp[arr[2]] = true;
		for(int i = arr[0]; i < 301; i++) {
			for(int j = 0; j < 3; j++) {
				if(i - arr[j] >= 0) {
					dp[i] = dp[i] || dp[i - arr[j]];
				}
			}
		}
		
		bw.write((dp[arr[3]] ? 1 : 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
