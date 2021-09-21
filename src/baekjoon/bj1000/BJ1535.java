package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//안녕
public class BJ1535 {
	static int[] loss;
	static int[] happy;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		loss = new int[N];
		happy = new int[N];
		dp = new int[N][101];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			loss[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		bw.write(solve(0, 100) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int health) {	//현재까지 n명을 만나고 체력이 health일때 최대 행복치
		if(n == N) {
			return 0;
		}
		
		if(dp[n][health] != -1) {
			return dp[n][health];
		}
		
		//각 단계에서 사람에게 인사를 하느냐, 안하느냐.
		return dp[n][health] = Math.max(solve(n + 1, health), (health - loss[n] <= 0 ? 0 : solve(n + 1, health - loss[n]) + happy[n]));
	}
}
