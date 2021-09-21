package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//진우의 달 여행(Small)
public class BJ17484 {
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {	//map[0][0] ~ map[0][M-1]에서 출발 가능
			result = Math.min(result, solve(0, i, -1));
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve(int n, int m, int k) {	//map[n][m]에 왔을때 소비하는 최소 연료
		if(n == N) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		if(m - 1 >= 0 && k != 0) {
			result = Math.min(result, solve(n + 1, m - 1, 0) + map[n][m]);
		}
		if(k != 1) {
			result = Math.min(result, solve(n + 1, m, 1) + map[n][m]);
		}
		if(m + 1 < M && k != 2) {
			result = Math.min(result, solve(n + 1, m + 1, 2) + map[n][m]);
		}
		return result;
	}
}
