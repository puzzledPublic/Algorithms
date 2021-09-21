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

//작업
public class BJ2056 {
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N + 1];	//진입차수
		int[] time = new int[N + 1];	//작업시간
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			time[i] = t;
			indegree[i] = c;
			for(int j = 0; j < c; j++) {
				int n = Integer.parseInt(st.nextToken());
				graph.get(n).add(i);	//n -> i로 선후관계
			}
		}
		
		int[] dp = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {	//진입차수가 0인 작업을 큐에 저장.
				queue.add(i);
				dp[i] = time[i];
			}
		}
		//위상정렬
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int next : graph.get(curr)) {
				dp[next] = Math.max(dp[next], dp[curr] + time[next]);	//next작업 전에 해야하는 작업들 중 가장 많이 걸리는 시간.
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(dp[i], result);
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
