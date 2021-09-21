package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//도시 분할 계획
public class BJ1647 {
	static int[] parent;
	static class Edge {
		int a, b, weight;
		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
	}
	static PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(a, b, w));
		}
		
		int cost = 0;
		int last = 0;	//union한 맨 마지막 간선 가중치를 저장.	(이 간선을 제거하면 2개의 마을이 생긴다.)
		while(!pq.isEmpty()) {	//최소 스패닝 트리의 가중치 계산.
			Edge edge = pq.poll();
			
			if(union(edge.a, edge.b)) {
				cost += edge.weight;
				last = edge.weight;
			}
		}
		
		bw.write((cost - last) + "\n");
		
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
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return false;
		}
		
		parent[u] = v;
		return true;
	}
}
