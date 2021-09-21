package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//과일 서리
public class BJ17213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	//과일 종류
		int M = Integer.parseInt(br.readLine());	//훔칠 개수
		
		int[][] dp = new int[M + 1][M + 1];	//dp[i][j] = j개의 종류 과일을 (각각 최소 1개이상) i개 훔칠때 가능한 경우의 수
		
		//파스칼의 삼각형
		dp[1][1] = 1;	//i == j or j == 1일때 훔치기 가능한 경우는 1가지.
		for(int i = 2; i <= M; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		bw.write(dp[M][N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
