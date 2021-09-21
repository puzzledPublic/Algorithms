package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//특정한 최단 경로
public class BJ1504 {
	static class Node {
		int vertex, weight;
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
		List<List<Node>> list = new ArrayList<>(N + 1);
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		int from, to, weight;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		
		long[] result1 = solve(list, 1, a, b, N);	//1 -> a, 1 -> b가는 최단거리
		long[] result2 = solve(list, N, a, b, N);	//N -> a, N -> b가는 최단거리
		long[] result3 = solve(list, a, b, 1, N);	//a -> b 가는 최단거리
		long result;	//Integer.MAX_VALUE가 있을 경우 이들을 더하면 오버플로우가 나므로 long타입으로 선언
		if(result1[0] + result2[1] < result1[1] + result2[0]) {	//( 1 -> a -> b -> N ) or ( 1 -> b -> a -> N ) 가는 최단거리 중 최소값이 정답.
			result = result1[0] + result2[1] + result3[0];
		}else {
			result = result1[1] + result2[0] + result3[0];
		}
		
		if(result >= Integer.MAX_VALUE) {	//가는 경로가 없는 경우
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		br.close();
	}
	//start에서 a, b로 가는 최단경로를 반환한다.
	static long[] solve(List<List<Node>> list, int start, int end, int end2, int n) {	//다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		int[] dist = new int[n + 1];
		for(int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cost = node.weight;
			int here = node.vertex;
			if(cost > dist[here]) {
				continue;
			}
			for(Node there : list.get(here)) {
				if(dist[there.vertex] > cost + there.weight) {
					dist[there.vertex] = cost + there.weight;
					pq.add(new Node(there.vertex, cost + there.weight));
				}
			}
		}
		return new long[]{ dist[end], dist[end2] };
	}
}
