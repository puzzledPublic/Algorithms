package baekjoon.bj2000;

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

//네트워크 복구
public class BJ2211 {
	static class State {
		int v, c;
		State(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<State>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new State(B, C));
			graph.get(B).add(new State(A, C));
		}
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.c - b.c);
		dist[1] = 0;
		queue.add(new State(1, 0));
		while(!queue.isEmpty()) {	//다익스트라, 정점 1에서 나머지 정점까지의 최소 거리를 구한다.
			
			State curr = queue.poll();
			
			if(curr.c > dist[curr.v]) continue;
			
			for(State next : graph.get(curr.v)) {
				if(curr.c + next.c < dist[next.v]) {
					dist[next.v] = curr.c + next.c;
					queue.add(new State(next.v, curr.c + next.c));
				}
			}
		}
		
		queue.clear();
		queue.add(new State(1, 0));
		boolean[] chk = new boolean[N + 1];
		chk[1] = true;
		
		List<State> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			State curr = queue.poll();
			
			for(State next : graph.get(curr.v)) {
				if(!chk[next.v] && curr.c + next.c <= dist[next.v]) {	//최소거리를 넘지 않는 간선들을 모은다.
					chk[next.v] = true; 
					list.add(new State(curr.v, next.v));
					queue.add(new State(next.v, curr.c + next.c));
				}
			}
		}
		
		bw.write(list.size() + "\n");
		for(State s : list) {
			bw.write(s.v + " " + s.c + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
