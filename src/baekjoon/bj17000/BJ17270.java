package baekjoon.bj17000;

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

//연예인은 힘들어
public class BJ17270 {
	static class Edge{
		int vertex, weight;
		Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	static int V, M, J, S;
	static List<List<Edge>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		J = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		//지헌, 성하 위치에서 다른 정점까지의 최단 거리
		int[] Jdist = dijkstra(J);
		int[] Sdist = dijkstra(S);
		
		//(전에 작성한 코드는 조건 3(Jdist[i] <= Sdist[i])을 먼저 판별해서 틀렸음. 조건 1, 2가 만족한 후 조건 3을 판별해야함)
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {	//최단 거리 합이 최소인 값을 찾는다.
			if((i != J && i != S) && (Jdist[i] != Integer.MAX_VALUE && Sdist[i] != Integer.MAX_VALUE)) {	//각자의 위치를 제외하고 두명이 도달 가능해야함 (조건1)
				if(min > Jdist[i] + Sdist[i]) {	//(조건2)
					min = Jdist[i] + Sdist[i];
				}
			}
		}
		
		int minDist = Integer.MAX_VALUE;
		int minPoint = -1;
		for(int i = 1; i <= V; i++) {
			if((i != J && i != S) && (Jdist[i] != Integer.MAX_VALUE && Sdist[i] != Integer.MAX_VALUE)) {
				if(min == Jdist[i] + Sdist[i] && Jdist[i] <= Sdist[i]) {	//지헌이 정점에 가는 시간이 성하가 가는 시간보다 같거나 더 짧은 것 중 최소인 정점을 탐색(조건3)
					if(minDist > Jdist[i]) {	//(조건4)
						minDist = Jdist[i];
						minPoint = i;
					}
				}
			}
		}
		
		bw.write(minPoint + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int[] dijkstra(int start) {
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge srcEdge = pq.poll();
			
			if(srcEdge.weight > dist[srcEdge.vertex]) {
				continue;
			}
			
			for(Edge dstEdge : graph.get(srcEdge.vertex)) {
				if(dist[dstEdge.vertex] > srcEdge.weight + dstEdge.weight) {
					dist[dstEdge.vertex] = srcEdge.weight + dstEdge.weight;
					pq.add(new Edge(dstEdge.vertex, srcEdge.weight + dstEdge.weight));
				}
			}
		}
		
		return dist;
	}
}

//플로이드로 푼것.

//public class BJ17270 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int V = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		int[][] graph = new int[V + 1][V + 1];
//		for(int i = 1; i <= V; i++) {
//			Arrays.fill(graph[i], 987654321);
//		}
//		
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int c = Integer.parseInt(st.nextToken());
//			if(graph[a][b] > c) {	//같은 정점간 거리가 여러번 주어질 수 있으므로 최소값을 넣도록 만든다.
//				graph[a][b] = graph[b][a] = c;
//			}
//		}
//		
//		int J, S;
//		st = new StringTokenizer(br.readLine(), " ");
//		J = Integer.parseInt(st.nextToken());
//		S = Integer.parseInt(st.nextToken());
//		
//		for(int k = 1; k <= V; k++) {
//			for(int i = 1; i <= V; i++) {
//				for(int j = 1; j <= V; j++) {
//					if(i != j && graph[i][j] > graph[i][k] + graph[k][j]) {
//						graph[i][j] = graph[i][k] + graph[k][j];
//					}
//				}
//			}
//		}
//		
//		int min = Integer.MAX_VALUE;
//		for(int i = 1; i <= V; i++) {
//			if((i != J && i != S) && (graph[J][i] != Integer.MAX_VALUE && graph[S][i] != Integer.MAX_VALUE)) {
//				if(min > graph[J][i] + graph[S][i]) {
//					min = graph[J][i] + graph[S][i];
//				}
//			}
//		}
//		
//		int minDist = Integer.MAX_VALUE;
//		int minPoint = -1;
//		for(int i = 1; i <= V; i++) {
//			if((i != J && i != S) && (graph[J][i] != Integer.MAX_VALUE && graph[S][i] != Integer.MAX_VALUE)) {
//				if(min == graph[J][i] + graph[S][i] && graph[J][i] <= graph[S][i]) {
//					if(minDist > graph[J][i]) {
//						minDist = graph[J][i];
//						minPoint = i;
//					}
//				}
//			}
//		}
//		
//		bw.write(minPoint + "\n");
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}
