package baekjoon.bj2000;

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

//음악 프로그램
public class BJ2623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[n + 1];	//진입차수
		List<List<Integer>> graph = new ArrayList<>();	//그래프
		for(int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {	//입력으로부터 그래프 생성
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k - 1; j++) {
				int s = Integer.parseInt(st.nextToken());
				indegree[s]++;
				graph.get(f).add(s);
				f = s;
			}
		}
		List<Integer> list = new ArrayList<>();	//결과 순서를 저장할 리스트
		Queue<Integer> queue = new LinkedList<>();	//위상정렬을 위한 큐
		
		for(int i = 1; i < n + 1; i++) {	//진입차수가 0인것부터 삽입.
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			list.add(current);
			for(int next : graph.get(current)) {	//진입차수가 0이되면 큐에 넣는다.
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		if(list.size() != n) {	//사이클이 존재하여 모든 정점이 포함되지 않으면 0
			bw.write("0\n");
		}else {
			for(int result : list) {	//사이클이 없이 위상정렬이 가능하면 리스트 출력
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
