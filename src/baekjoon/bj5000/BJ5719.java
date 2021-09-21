package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//거의 최단 경로
public class BJ5719 {
	static class Vertex {
		int u, weight;
		Vertex(int u, int weight) {
			this.u = u;
			this.weight = weight;
		}
	}
	static List<List<Vertex>> graph;	//그래프
	static List<List<Integer>> back;	//최단 경로 그래프
	static int[] dist;
	static int N, M, S, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) {
				break;
			}
			
			graph = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < M; i++) {	//그래프 만들기
				st = new StringTokenizer(br.readLine(), " ");
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				graph.get(U).add(new Vertex(V, P));
			}
			
			int minDist = dijkstra();	//다익스트라 한번 돌려 현재 최단 거리를 구함
			deleteEdge(D);
			int nextMinDist = dijkstra();
//			nextMinDist = minDist;
//			deleteEdge(D);	//최단 거리를 이루는 경로를 제거
//			while(nextMinDist != 987654321 && minDist == nextMinDist) {	//최단 거리가 존재하지 않거나 처음에 구한 최단거리와 다를때까지 거의 최단 경로를 구한다.
//				nextMinDist = dijkstra();	//다음 최단 경로
//				deleteEdge(D);	//경로 제거
//			}
			
			bw.write((nextMinDist == 987654321 ? -1 : nextMinDist) + "\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void deleteEdge(int dst) {	//경로 제거 함수, 구한 경로(back)로 dfs를 하며 경로를 제거한다.
		if(back.get(dst).size() == 0) {
			return;
		}
		for(int src : back.get(dst)) {
			final int tmp = dst;
			graph.get(src).removeIf(vertex -> vertex.u == tmp);
			deleteEdge(src);
		}
	}
	
	static int dijkstra() {	//최단 거리를 구하기 위한 다익스트라 알고리즘
		dist = new int[N];
		back = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			dist[i] = 987654321;
			back.add(new ArrayList<>());
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		dist[S] = 0;
		pq.add(new Vertex(S, 0));
		while(!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			int curr = vertex.u;
			int cost = vertex.weight;
			
			if(dist[curr] < cost) {
				continue;
			}
			
			for(Vertex next : graph.get(curr)) {
				if(dist[next.u] >= cost + next.weight) {	//curr -> next로 갈때 현재까지 구한 최단거리와 같거나 작은 경우.
					
					if(dist[next.u] > cost + next.weight) {	//만일 이전에 구한 최단거리보다 더 짧다면 현재 최단 거리를 이루는 경로를 다 버리고 새로 추가.
						back.get(next.u).clear();
						back.get(next.u).add(curr);
					}else {
						if(!back.get(next.u).contains(curr)) {	//이전에 구한 최단거리와 같은 경우 최단 거리를 이루는 경로를 추가한다.
							back.get(next.u).add(curr);
						}						
					}
					
					dist[next.u] = cost + next.weight;
					pq.add(new Vertex(next.u, cost + next.weight));
				}
			}
		}
		
		return dist[D];
	}
}
