package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS
public class BJ1260 {
	static boolean[][] graph;
	static boolean[] chk;
	static int N, M, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		chk = new boolean[N + 1];
		int a, b;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}
		dfs(V, bw);
		bw.write("\n");
		for(int i = 1; i <= N; i++) {
			chk[i] = false;
		}
		bfs(V, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int v, Writer w) throws IOException {
		w.write(v + " ");
		chk[v] = true;
		for(int i = 1; i <= N; i++) {
			if(graph[v][i] && chk[i] == false) {
				dfs(i, w);
			}
		}
	}
	static void bfs(int v, Writer w) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		chk[v] = true;
		q.add(v);
		while(!q.isEmpty()) {
			int c = q.poll();
			w.write(c + " ");
			for(int i = 1; i <= N; i++) {
				if(graph[c][i] && chk[i] == false) {
					chk[i] = true;
					q.add(i);
				}
			}
		}
	}
}
