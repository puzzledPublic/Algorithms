package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//정점들의 거리
public class BJ1761 {
	static class Edge {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int N;
	static List<List<Edge>> tree = new ArrayList<>();
	static int[][] parent;	//parent[i][j] = i정점에서 2^j 높이의 부모 정점
	static int[] depth;	//depth[i] = 트리에서 i정점의 깊이
	static int[][] dist;	//dist[i][j] = i정점에서 2^j 높이의 부모 정점까지의 거리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		parent = new int[N + 1][17];
		depth = new int[N + 1];
		dist = new int[N + 1][17];
		
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
			Arrays.fill(dist[i], -1);
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree.get(u).add(new Edge(v, w));
			tree.get(v).add(new Edge(u, w));
		}
		
		//1을 최상위 루트로 정한다.
		depth[1] = 1;
		dist[1][0] = 0;
		dfs(1);
		
		//i정점의 2^j번째 부모 정점을 구한다.
		for(int j = 0; j < 16; j++) {
			for(int i = 1; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					parent[i][j + 1] = parent[parent[i][j]][j];
				}
			}
		}
		
		//i정점의 2^j번째 부모 정점까지의 거리를 구한다.
		for(int j = 0; j < 16; j++) {
			for(int i = 1; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					dist[i][j + 1] = dist[parent[i][j]][j] + dist[i][j];
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int distance = 0;
			
			if(depth[u] < depth[v]) {
				int temp = u;
				u = v;
				v = temp;
			}
			
			int diff = depth[u] - depth[v];
			
			for(int j = 0; diff > 0; j++) {
				if(diff % 2 > 0) {
					distance += dist[u][j];
					u = parent[u][j];
				}
				diff /= 2;
			}
			
			if(u != v) {
				for(int j = 16; j >= 0; j--) {
					if(parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
						distance += (dist[u][j] + dist[v][j]);
						u = parent[u][j];
						v = parent[v][j];
					}
				}
				distance += (dist[u][0] + dist[v][0]);
				u = parent[u][0];
			}
			
			bw.write(distance + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		for(Edge sub : tree.get(root)) {
			if(depth[sub.v] == 0) {
				depth[sub.v] = depth[root] + 1;	//현재 정점의 깊이
				parent[sub.v][0] = root;	//현재 정점의 부모 정점
				dist[sub.v][0] = sub.w;	//현재 정점에서 부모 정점까지 거리
				dfs(sub.v);
			}
		}
	}
}
