package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//죽음의 게임
public class BJ17204 {
	static int[] graph;
	static boolean[] visited;
	static int N, K, result = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[N];	//각 정점당 방향 간선이 하나이기에 1차원 배열이면 된다.
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0);
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int src, int depth) {
		visited[src] = true;
		if(src == K) {
			result = depth;
			return;
		}
		if(!visited[graph[src]]) {
			dfs(graph[src], depth + 1);
		}
	}
}
