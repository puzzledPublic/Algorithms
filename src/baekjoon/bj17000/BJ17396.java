package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백도어
public class BJ17396 {
	static class Node {
		int vertex;
		long weight;
		Node(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	static List<List<Node>> graph = new ArrayList<>();
	static boolean[] sight;
	static long dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sight = new boolean[N];
		dist = new long[N];
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = 10987654321L;
		}
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {	//시야가 보이는 거점 true로 체크
			sight[i] = st.nextToken().charAt(0) == '0' ? false : true;
		}
		sight[N - 1] = false;	//마지막 거점은 그래프에 포함 되어야 하므로 false로 강제
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			if(sight[s] || sight[e]) {	//시야가 보이는 거점이면 갈 수 없으므로 그래프서 제외
				continue;
			}else {	//그래프 생성
				graph.get(s).add(new Node(e, w));
				graph.get(e).add(new Node(s, w));
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
		dist[0] = 0;
		pq.add(new Node(0, 0));
		while(!pq.isEmpty()) {	//다익스트라
			Node curr = pq.poll();
			
			if(curr.weight > dist[curr.vertex]) {
				continue;
			}
			
			for(Node next : graph.get(curr.vertex)) {
				if(dist[next.vertex] > curr.weight + next.weight) {
					dist[next.vertex] = curr.weight + next.weight;
					pq.add(new Node(next.vertex, curr.weight + next.weight));
				}
			}
		}
		
		bw.write((dist[N - 1] == 10987654321L ? -1 : dist[N - 1]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}