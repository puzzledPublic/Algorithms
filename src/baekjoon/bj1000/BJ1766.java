package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//문제집	(위상 정렬)
public class BJ1766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N + 1];	//각 정점의 진입 차수
		List<Integer>[] graph = new List[N + 1];	//그래프
		
		for(int i = 0; i < M; i++) {	//입력 처리 및 그래프 생성
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if(graph[a] == null) {
				graph[a] = new ArrayList<>();
			}
			graph[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();	//최대한 쉬운(번호가 낮은) 문제부터 풀어야 하므로 우선순위 큐를 사용
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {	//진입 차수가 0인것부터 삽입
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			bw.write(current + " ");	//출력
			if(graph[current] != null) {
				for(int next : graph[current]) {	//연결된 정점들에 대해 진입차수를 감소하며 다음 탐색할 정점을 삽입
					indegree[next]--;
					if(indegree[next] == 0) {
						pq.add(next);
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
