package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//KCM Travel
public class BJ10217 {
	static class Edge {
		int vertex, cost, dist;
		Edge(int vertex, int cost, int dist) {
			this.vertex = vertex;
			this.cost = cost;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			List<List<Edge>> graph = new ArrayList<>();
			for(int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				
				graph.get(U).add(new Edge(V, C, D));
			}
			
			int[][] dist = new int[N + 1][M + 1];	//dist[i][j] = i 노드에 j비용을 써서 도착했을때 최소 거리
			for(int i = 0; i < N + 1; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			Arrays.fill(dist[1], 0);
			
			PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
			pq.add(new Edge(1, 0, 0));
			while(!pq.isEmpty()) {	//다익스트라.
				
				Edge curr = pq.poll();
				
				if(curr.dist > dist[curr.vertex][curr.cost]) {
					continue;
				}
				
				for(Edge next: graph.get(curr.vertex)) {
					if(curr.cost + next.cost <= M) {
						if(dist[next.vertex][curr.cost + next.cost] > curr.dist + next.dist) {
							dist[next.vertex][curr.cost + next.cost] = curr.dist + next.dist;
							pq.add(new Edge(next.vertex, curr.cost + next.cost, curr.dist + next.dist));
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 1 ; i < M + 1; i++) {
				min = Math.min(min, dist[N][i]);
			}
			
			bw.write((min == Integer.MAX_VALUE ? "Poor KCM" : min) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
