package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//행렬 곱셈 순서
public class BJ11049 {
	static long[][] mat;
	static long[][] dp;	//dp[i][j] = i ~ j 까지의 행렬을 곱했을때 최소 연산 횟수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		mat = new long[N][2];
		dp = new long[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < N; j++) {
				dp[i][j] = Long.MAX_VALUE;
			}
			dp[i][i] = 0;
		}
		
		bw.write(solve(0, N - 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int a, int b) {
		if(b - a == 1) {	//인접한 행렬 곱인 경우
			dp[a][b] = mat[a][0] * mat[a][1] * mat[b][1];
			return dp[a][b];
		}
		if(dp[a][b] != Long.MAX_VALUE) {	//메모이제이션
			return dp[a][b];
		}
		for(int i = a; i < b; i++) {	//a~b까지의 행렬 곱셈 횟수 = a~i까지 행렬 곱셈 횟수 + i+1~b까지 행렬 곱셈 횟수 + 그 둘의 행렬 곱셈 횟수
//			if(a == i) {
//				dp[a][b] = Math.min(dp[a][b], solve(a, i) + solve(i + 1, b) + mat[a][0] * mat[i + 1][0] * mat[b][1]);
//			}else {
				dp[a][b] = Math.min(dp[a][b], solve(a, i) + solve(i + 1, b) + mat[a][0] * mat[i][1] * mat[b][1]);
//			}
		}
		return dp[a][b];
	}
}
