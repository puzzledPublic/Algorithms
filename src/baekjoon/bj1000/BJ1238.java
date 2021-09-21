package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//파티
public class BJ1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			Arrays.fill(map[i], 987654321);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		bw.write(solve(map, X, N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int[][] map, int X, int N) {
		for(int k = 1; k < N + 1; k++) {	//플로이드-와샬 최단거리 O(v^3)	(v = 1000이어서 아슬아슬하게 통과)
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i < N + 1; i++) {
			if(i != X && max < map[i][X] + map[X][i]) {	//i에서 X에 가는 경로 + X에서 i로 가는 경로 중 최소값 , 본인 집에서 파티를 하는 경우는 최단경로가 0이므로 무시한다.
				max = map[i][X] + map[X][i];
			}
		}
		return max;
	}
}
