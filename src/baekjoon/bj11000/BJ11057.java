package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//오르막 수
public class BJ11057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		bw.write(solve(N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int N) {
		int mod = 10007;
		int[][] dp = new int[N + 1][10];	//dp[i][j] = i번째 자리에 j번째 숫자가 왔을때 오르막수의 개수
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i < N + 1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {	//오르막수가 되려면 바로 이전의 숫자([i-1][k])는 현재 숫자([i][j])보다 같거나 작아야한다. 
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
				}
			}
		}
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result = (result + dp[N][i]) % mod;
		}
		return result;
	}
}
