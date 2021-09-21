package baekjoon.bj1000;

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

//게임 개발 (위상 정렬)
public class BJ1516 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] indegree = new int[N + 1];	//각 정점의 진입 차수
		int[] times = new int[N + 1];		//각 정점만 건설하는데 드는 시간
		int[] result = new int[N + 1];		//각 정점을 최종적으로 건설하는데 드는 시간
		List<List<Integer>> graph = new ArrayList<>();	//정점들의 의존 그래프
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i < N + 1; i++) {	//입력 처리 및 그래프 생성
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			times[i] = Integer.parseInt(st.nextToken());
			int before;
			while((before = Integer.parseInt(st.nextToken())) != -1) {
				indegree[i]++;
				graph.get(before).add(i);
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i < N + 1; i++) {	//진입차수가 0인 정점을 큐에 삽입
			if(indegree[i] == 0) {
				queue.add(i);
				result[i] = times[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int next : graph.get(current)) {
				indegree[next]--;	//진입 차수 감소
				if(result[next] < result[current] + times[next]) {	//각 정점으로 가는 시간 중 가장 큰 시간이 그 정점이 걸리는 시간이 된다.
					result[next] = result[current] + times[next];
				}
				if(indegree[next] == 0) {	//진입 차수가 0이 되면 다음 탐색 정점으로한다.
					queue.add(next);
				}
			}
		}
		
		for(int i = 1; i < N + 1; i++) {	//각 정점이 건설되는 시간을 출력
			bw.write(result[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
