package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//행성 연결(최소 비용 신장 트리)
public class BJ16398 {
	static int[] parent;
	static int[] rank;
	static class FlowInfo {
		int x, y, cost;
		public FlowInfo(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] planet = new int[N][N];
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<FlowInfo> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				pq.add(new FlowInfo(i, j, planet[i][j]));
			}
		}
		
		long totalCost = 0;
		while(!pq.isEmpty()) {
			FlowInfo fi = pq.poll();
			if(find(fi.x) != find(fi.y)) {
				union(fi.x, fi.y);
				totalCost += fi.cost;
			}
		}
		
		bw.write(totalCost + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return;
		}
		
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) {
			rank[v]++;
		}
	}
}
