package java8;

import java.util.Arrays;

//시작점에서 모든 정점까지의 최단 경로를 구하는 알고리즘
public class BellmanFord {
	static final int INF = 987654321;
	static int adj[][] = {
		{0,     1,   INF,   5,   2,   8,   4,   INF},
		{1,     0,     2, INF, INF,   5, INF,   INF},
		{INF,   2,     0,   3,   8,   1, INF,   INF},
		{5  , INF,     3,   0,   1, INF, INF,     4},
		{2  , INF,     8,   1,   0,   5,   1,     5},
		{8  ,   5,     1, INF,   5,   0, INF,   INF},
		{4  , INF,   INF, INF,   1, INF,   0,     1},
		{INF, INF,   INF,   4,   5, INF,   1,     0}
	};
	static int upper[];
	static int V;
	public static void main(String[] args) {
		V = adj.length;
		upper = new int[adj.length];
		
		Arrays.fill(upper, INF);
		bellmanFord(0);
		System.out.println(Arrays.toString(upper));
	}
	// 시작점에서 u, v 정점으로 가는 최단거리가 dist[u], dist[v]라고 할때 dist[v] <= dist[u] + w(u,v)를 만족함을 이용한다. w(u,v)는 u->v의 가중치
	static void bellmanFord(int src) {
		
		upper[src] = 0;
		for(int i = 0; i < V; i++) {
			for(int here = 0; here < V; here++) {
				for(int there = 0; there < adj[here].length; there++) {
					if(adj[here][there] != INF) {
						if(upper[there] > upper[here] + adj[here][there]) {
							upper[there] = upper[here] + adj[here][there];
						}
					}
				}
			}
		}
		
	}
}
