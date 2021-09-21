package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//키 순서
public class BJ2458 {
	static boolean[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		for(int k = 1; k < N + 1; k++) {	//플로이드 와샬
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(graph[i][k] && graph[k][j]) {
						graph[i][j] = true;
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i < N + 1; i++) {
			int count = 0;
			for(int j = 1; j < N + 1; j++) {
				if(graph[i][j] || graph[j][i]) {	//i로 올 수 있는 정점의 수(i보다 키가 작은 사람들) + i에서 갈 수 있는 정점의 수(i보다 키가 큰 사람들) = 총 인원(N) - 1(본인)
					count++;
				}
			}
			if(count == N - 1) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
/*
 * 처음 풀이(dfs로 각 정점에서 갈 수있는 정점을 다 체크하고 오는 정점 수,가는 정점 수 세서 총인원 - 1인지 계산
public class BJ2458 {
	static boolean[][] graph;
	static boolean[][] copy;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		copy = new boolean[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			copy[a][b] = graph[a][b] = true;
		}
		
		visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {	//각 정점에서 도달할 수 있는 정점을 모두 체크
			Arrays.fill(visited, false);
			dfs(i, i);
		}
		
		int result = 0;
		for(int i = 1; i < N + 1; i++) {
			int count = 0;
			for(int j = 1; j < N + 1; j++) {
				if(copy[i][j] || copy[j][i]) {
					count++;
				}
			}
			if(count == N - 1) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int origin, int start) {	//dfs돌며 origin에서 갈 수 있는 정점을 copy배열에 체크
		for(int i = 1; i < graph.length; i++) {
			if(!visited[i] && graph[start][i]) {
				visited[i] = true;
				copy[origin][i] = true;
				dfs(origin, i);
			}
		}
	}
}*/