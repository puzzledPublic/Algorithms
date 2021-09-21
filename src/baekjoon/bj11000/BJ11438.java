package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//LCA 2
public class BJ11438 {
	static int[][] parent;
	static int[] depth;
	static List<List<Integer>> tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		tree = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		tree.get(0).add(1);
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		parent = new int[N + 1][18];
		depth = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
		}
		Arrays.fill(depth, -1);
		depth[0] = 0;
		
		dfs(0);
		
		for(int j = 0; j < 17; j++) {
			for(int i = 0; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					parent[i][j + 1] = parent[parent[i][j]][j];
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(depth[u] < depth[v]) {
				int temp = u;
				u = v;
				v = temp;
			}
			
			int diff = depth[u] - depth[v];
			
			for(int j = 0; diff > 0; j++) {
				if(diff % 2 > 0) {
					u = parent[u][j];
				}
				diff /= 2;
			}
			
			if(u != v) {
				for(int j = 17; j >= 0; j--) {
					if(parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
						u = parent[u][j];
						v = parent[v][j];
					}
				}
				u = parent[u][0];
			}
			
			bw.write(u + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		for(int sub : tree.get(root)) {
			if(depth[sub] == -1) {
				depth[sub] = depth[root] + 1;
				parent[sub][0] = root;
				dfs(sub);
			}
		}
	}
}
