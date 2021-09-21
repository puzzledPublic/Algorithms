package baekjoon.bj9000;

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

//미확인 도착지
public class BJ9370 {
	static class State {
		int vertex, weight;
		State(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());	//테스트 케이스 수
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	//교차로 수
			int M = Integer.parseInt(st.nextToken());	//도로 수
			int K = Integer.parseInt(st.nextToken());	//목적지 후보 수
			
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());	//출발지
			int G = Integer.parseInt(st.nextToken());	//지나야하는 교차로
			int H = Integer.parseInt(st.nextToken());	//지나야하는 교차로
			
			List<List<State>> graph = new ArrayList<>();	//그래프
			for(int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				graph.get(A).add(new State(B, D));	//양방향 도로
				graph.get(B).add(new State(A, D));
			}
			
			int[] dst = new int[K];	//목적지 후보들
			for(int i = 0; i < K; i++) {
				dst[i] = Integer.parseInt(br.readLine());
			}
			
			int[] distFromS = minDist(graph, N, S);	//출발지(S)에서 모든 교차로까지의 최단거리
			int[] distFromG = minDist(graph, N, G);	//지나야하는 교차로 G에서 모든 교차로까지의 최단거리 
			int[] distFromH = minDist(graph, N, H);	//지나야하는 교차로 H에서 모든 교차로까지의 최단거리
			
			List<Integer> result = new ArrayList<>();
			for(int i = 0; i < dst.length; i++) {
				int r1 = distFromG[S] + distFromG[H] + distFromH[dst[i]];	//S -> G -> H -> 도착지까지 가는 최단거리
				int r2 = distFromH[S] + distFromH[G] + distFromG[dst[i]];	//S -> H -> G -> 도착지까지 가는 최단거리
				if(r1 == distFromS[dst[i]] || r2 == distFromS[dst[i]]) {	//위의 최단거리 중 하나라도 S -> 도착지까지 가는 최단거리와 같다면 G-H간선을 지나긴다.
					result.add(dst[i]);
				}
			}
			
			//오름차순 출력을 위한 정렬
			result.sort((a, b) -> a - b);
			
			for(int d : result) {
				bw.write(d + " ");
			}
			bw.write("\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//시작점 S에서 모든점까지의 최단거리. 다익스트라
	static int[] minDist(List<List<State>> graph, int N, int S) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		queue.add(new State(S, 0));
		dist[S] = 0;
		while(!queue.isEmpty()) {
			State s = queue.poll();
			
			if(s.weight > dist[s.vertex]) {
				continue;
			}
			
			for(State next : graph.get(s.vertex)) {
				if(s.weight + next.weight < dist[next.vertex]) {
					dist[next.vertex] = s.weight + next.weight;
					queue.add(new State(next.vertex, s.weight + next.weight));
				}
			}
		}
		return dist;
	}
}
