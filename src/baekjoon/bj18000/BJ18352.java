package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//특정 거리의 도시 찾기
public class BJ18352 {
	static class Pair {
		int v, t;
		Pair(int v, int t) {
			this.v = v;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
		}
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, -1);
		
		Queue<Pair> queue = new LinkedList<>(); 
		queue.add(new Pair(X, 0));
		dist[X] = 0;
		while(!queue.isEmpty()) {	//BFS
			Pair p = queue.poll();
			
			for(int next : graph.get(p.v)) {
				if(dist[next] == -1) {
					dist[next] = p.t + 1;
					queue.add(new Pair(next, p.t + 1));
				}
			}
		}
		
		boolean possible = false;
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {	//거리가 K인 정점 출력
				possible = true;
				bw.write(i + "\n");
			}
		}
		
		if(!possible) {
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
