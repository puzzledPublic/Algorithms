package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//자두나무
public class BJ2240 {
	static int T, W;
	static int[] fall;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		fall = new int[T];
		dp = new int[T + 1][W + 1][3];
		
		for(int i = 0; i <= T; i++) {
			for(int j = 0; j <= W; j++) {
				for(int k = 0; k < 3; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			fall[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(solve(0, 0, 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int t, int w, int k) {	//t초이고 w번 이동을 사용하고 현재 위치가 k일때 얻을 수 있는 자두의 최대 개수
		if(t == T) {	//시간이 끝나면 종료
			return 0;
		}
		
		if(dp[t][w][k] != Integer.MIN_VALUE) {	//Memoization
			return dp[t][w][k];
		}
		
		if(t == 0 && fall[t] == 2 && w + 1 <= W) {	//만약 0초에 자두가 떨어지는 곳이 1이 아닌 2인 경우 바로 옮겨서 먹을 수 있다.
			dp[t][w][k] = solve(t, w + 1, 2);
		}
		
		if(k == fall[t]) {	//현재 위치에서 자두가 떨어지면 자두개수 + 1
			dp[t][w][k] = Math.max(dp[t][w][k], solve(t + 1, w, k) + 1);	//다음 초에도 그대로 있는 경우 
			if(w + 1 <= W) {	//자리 이동 가능하며 다음 초에 다른 위치로 가는 경우
				dp[t][w][k] = Math.max(dp[t][w][k], solve(t + 1, w + 1, 3 - k) + 1);
			}
		}else {	//현재 위치에서 자두가 떨어지지 않으면 자두개수 + 0
			dp[t][w][k] = Math.max(dp[t][w][k], solve(t + 1, w, k));	//다음 초에도 그대로 있는 경우
			if(w + 1 <= W) {	//자리 이동 가능하며 다음 초에 다른 위치로 가는 경우
				dp[t][w][k] = Math.max(dp[t][w][k], solve(t + 1, w + 1, 3 - k));
			}
		}
		
		return dp[t][w][k];
	}
}
