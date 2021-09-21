package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//카드 게임 (minmax tree or algorithm)
public class BJ11062 {
	static int[] cards;
	static int[][][] dp;
	static int[][] dp2;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cards = new int[N];
			dp = new int[N][N][2];
			dp2 = new int[N][N];
			for(int i = 0; i < N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dp[i][j][0] = dp[i][j][1] = -1;
				}
			}
			bw.write(solve(0, N - 1, 0) + "\n");
			bw.write(solve2(0, N - 1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//b == 0 => 나의 턴, b == 1 => 상대방 턴
	static int solve(int s, int e, int b) {
		if(s == e) {
			return dp[s][e][b] = (b == 0 ? cards[s] : 0);
		}
		
		if(dp[s][e][b] != -1) {
			return dp[s][e][b];
		}
		
		if(b == 0) {	//나의 턴일 때 큰 값일수록 좋다.
			dp[s][e][b] = Math.max(solve(s + 1, e, 1 - b) + cards[s], solve(s , e - 1, 1 - b) + cards[e]);
		}else {	//상대방 턴일 때 작은 값일수록 좋다.
			dp[s][e][b] = Math.min(solve(s + 1, e, 1 - b), solve(s, e - 1, 1 - b));
		}
		return dp[s][e][b];
	}
	
	//변수로 턴을 나타내지 않고 현재 남은 수들의 개수로 알 수 있다.
	//처음 수들의 개수가 짝수개라면 앞으로도 짝수개일 때는 나의 턴, 홀수개일 때는 상대방의 턴이고 처음 수들의 개수가 홀수개라면 그 반대이다.
	static int solve2(int s, int e) {
		if(s == e) {
			return dp2[s][e] = ((N - (s + e) + 1) % 2 == 0 ? cards[s] : 0); 
		}
		
		if(dp2[s][e] != 0) {
			return dp2[s][e];
		}
		
		if((N - (s + e) + 1) % 2 == 0) {
			dp2[s][e] = Math.max(solve2(s + 1, e) + cards[s], solve2(s, e - 1) + cards[e]);
		}else {
			dp2[s][e] = Math.min(solve2(s + 1, e), solve2(s, e - 1));
		}
		return dp2[s][e];
	}
}
