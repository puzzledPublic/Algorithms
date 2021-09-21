package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//줄 세우기 (위상정렬)
public class BJ2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		List<Integer>[] graph = new List[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if(graph[a] == null) {
				graph[a] = new LinkedList<>();
			}
			graph[a].add(b);	//그래프 생성
			indegree[b]++;		//해당 정점 진입차수 계산
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i < indegree.length; i++) {	//진입차수가 0인 정점들부터 탐색
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int c = pq.poll();
			if(graph[c] != null) {
				for(Integer i : graph[c]) {	//해당 정점에서 이어지는 정점들을 탐색
					indegree[i]--;			//이어지는 정점들의 진입차수를 가감
					if(indegree[i] == 0) {	//진입차수가 0이되면 큐에 넣어 다음 탐색 정점으로 둔다.
						pq.add(i);
					}
				}
			}
			bw.write(c + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
