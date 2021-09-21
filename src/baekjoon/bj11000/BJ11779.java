package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소비용 구하기 2
public class BJ11779 {
	static class Edge {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Edge(e, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N + 1];
		int[] track = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
			track[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		pq.add(new Edge(S, 0));
		dist[S] = 0;
		while(!pq.isEmpty()) {	//다익스트라
			Edge curr = pq.poll();
			
			if(curr.w > dist[curr.v]) continue;
			
			for(Edge next: graph.get(curr.v)) {
				if(dist[next.v] > curr.w + next.w) {
					dist[next.v]= curr.w + next.w;
					track[next.v] = curr.v;	//최소값 갱신할 때 curr -> next로 갔음을 표시 
					pq.add(new Edge(next.v, curr.w + next.w));
				}
			}
		}
		
		List<Integer> result = new ArrayList<>();
		int index = E;
		while(track[index] != index) {	//거꾸로 탐색하며 경로를 만든다.
			result.add(index);
			index = track[index];
		}
		
		bw.write(dist[E] + "\n");	//최소 경로 가중치
		bw.write((result.size() + 1) + "\n");	//경로 길이
		bw.write(S + " ");	//경로 시작점.
		for(int i = result.size() - 1; i >= 0; i--) {	//경로 출력
			bw.write(result.get(i) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
