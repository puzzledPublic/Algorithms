package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단 경로
public class BJ1753 {
	static class Node {
		public int vertex, weight;
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
		List<List<Node>> list = new ArrayList<>();
		int[] dist = new int[V + 1];	//시작점에서 각 i 정점까지 가는 최소 가중치
		
		for(int i = 0; i < V + 1; i++) {
			list.add(new LinkedList<>());
			dist[i] = 987654321;	//INF로 초기화
		}
		int start = Integer.parseInt(br.readLine());
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		solve(list, dist, start);
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == 987654321) {
				bw.write("INF\n");
			}else {
				bw.write(dist[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//다익스트라 최단 경로 알고리즘
	static void solve(List<List<Node>> list, int[] dist, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);	//가중치가 낮은순으로
		dist[start] = 0;	//자기 정점은 거리가 0
		pq.add(new Node(start, 0));	//시작 노드 큐에 삽입
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();	//현재 방문 노드
			int cost = node.weight;	
			int here = node.vertex;
			
			if(cost > dist[here]) {	//우선순위 큐라서 방문가능한 노드를 모두 넣으므로 후 순위로 밀려난 노드들을 찾았을때 이미 더 작은 최소 가중치가 존재하면 무시
				continue;
			}
			
			for(Node n : list.get(here)) {	//현재 방문 노드에서 갈 수 있는 정점들 탐색
				if(dist[n.vertex] > cost + n.weight) {	//이미 구한 가중치 보다 더 적게 도달 가능하면
					dist[n.vertex] = cost + n.weight;	//가중치 갱신
					pq.add(new Node(n.vertex, cost + n.weight));	//노드 방문
				}
			}
		}
	}
}
