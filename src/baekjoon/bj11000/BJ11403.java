package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//경로 찾기
public class BJ11403 {
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {	//각 정점에서 시작해서 dfs
			Arrays.fill(visited, false);
			solve(map, i);
			for(int j = 0; j < N; j++) {
				bw.write((visited[j]? 1 : 0) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int[][] map, int start) { //dfs
		for(int i = 0; i < map.length; i++) {
			if(!visited[i] && map[start][i] == 1) {
				visited[i] = true;
				solve(map, i);
			}
		}
	}
}
