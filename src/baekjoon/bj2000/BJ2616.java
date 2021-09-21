package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//소형기관차
public class BJ2616 {
	static int[][] dp;
	static int[][] dp2;
	static int[] train;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 2][3];
		dp2 = new int[N + 2][4];
		
		train = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			train[i] = Integer.parseInt(st.nextToken()) + train[i - 1];
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 0; j < 3; j++) {
				dp[i][j] = -1;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		bw.write(solve2() + "\n");
		
		bw.write(solve(1, 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve2() {
		//dp2[i][j] = j번째 기관차를 1 ~ j 객실 사이에 배치해서 수송할 수 있는 최대 인원수 
		for(int j = 1; j <= 3; j++) {
			for(int i = j * M; i < N + 1; i++) {	//j번째 기관차를 놓으려면 최소 1번 객실로부터 j*m 떨어진 객실이다. (j번째 이전 기관차들을 놓아야 하므로)
				//j번째 기관차를 1 ~ (j-1) 객실 사이에 배치해서 수송할 수 있는 최대 인원수, 
				//j번째 기관차를 (i-m) ~ i 객실에 배치했을 때 인원수 + j-1번째 기관차를 1 ~ (i-m) 객실 사이에 배치해서 수송할 수 있는 최대 인원수
				//둘 중 최대값이 dp2[i][j]값이 된다.
				dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i - M][j - 1] + train[i] - train[i - M]);
			}
		}
		return dp[N][3];
	}
	
	//시간초과 (겹치는 경우가 별로 없음. -> dp 배열이 효과 없음)
	static int solve(int start, int k) {	//dp[start][k] = start 객실부터 k개의 기관차를 배치할 때 수송할 수 있는 최대 인원수
		if(k == 3) {
			return 0;
		}
		
		if(dp[start][k] != -1) {
			return dp[start][k];
		}
		
		for(int i = start; i < N - (3 - k) * M + 2; i++) {
			//i ~ (i+m) 객실을 k번째 기관차가 끌고 나머지 기관차들은 다시 i+m 부터 탐색.
			dp[start][k] = Math.max(dp[start][k], solve(i + M, k + 1) + (train[i + M - 1] - train[i - 1]));
		}
		
		return dp[start][k];
	}
}
