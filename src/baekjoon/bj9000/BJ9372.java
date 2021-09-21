package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//상근이의 여행(BFS)
//BFS말고 다른 풀이는 최소스패닝트리를 떠올려보면 최소스패닝트리를 이루는 간선의 갯수는 정점 - 1개이다. 즉 정점의 수(N)만 알면 N-1이 정답이 된다.
public class BJ9372 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			for(int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			boolean[] visited = new boolean[N + 1];	//방문 체크 배열
			
			for(int i = 0; i < M; i++) {	//그래프 생성
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			int count = 0;
			Queue<Integer> queue = new LinkedList<>();	//BFS
			queue.add(1);
			visited[1] = true;
			while(!queue.isEmpty()) {
				int index = queue.poll();
				for(int next : graph.get(index)) {
					if(!visited[next]) {
						count++;
						visited[next] = true;
						queue.add(next);
					}
				}
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
