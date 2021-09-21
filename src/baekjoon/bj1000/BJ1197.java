package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소 스패닝 트리
public class BJ1197 {
	static class Edge {
		int v1, v2, weight;
		Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}
	static int[] rank;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		rank = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(v1, v2, weight));
		}
		
		int cost = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(union(edge.v1, edge.v2)) {
				cost += edge.weight;
				count++;
			}
			if(count == V - 1) {
				break;
			}
		}
		
		bw.write(cost + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int u) {
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return false;
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
		
		return true;
	}
}