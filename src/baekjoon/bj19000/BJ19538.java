package baekjoon.bj19000;

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

//루머
public class BJ19538 {
	static class State {
		int num, time;
		State(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] neighbor = new int[N + 1];
		int[] time = new int[N + 1];
		Arrays.fill(time, -1);
		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			neighbor[i] = st.countTokens() - 1;	//인접 정점 개수
			int ne;
			while((ne = Integer.parseInt(st.nextToken())) != 0) {	//그래프 생성
				if(i < ne) {	//중복 입력되는 정점을 피하기 위한 조건
					graph.get(i).add(ne);
					graph.get(ne).add(i);
				}
			}
		}
		
		//각 정점이 루머를 믿기위한 루머를 믿는 인접 정점의 개수
		for(int i = 1; i <= N; i++) {
			neighbor[i] = (neighbor[i] % 2 == 0 ? neighbor[i] / 2 : (neighbor[i] / 2) + 1);
		}
		
		Queue<State> queue = new LinkedList<>();

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {	//처음 루머를 믿는 정점들
			int v = Integer.parseInt(st.nextToken());
			queue.add(new State(v, 0));
			time[v] = 0;
		}
		
		
		while(!queue.isEmpty()) {
			State curr = queue.poll();
			
			for(int next : graph.get(curr.num)) {
				neighbor[next]--;	//루머 전파
				if(time[next] == -1 && neighbor[next] == 0) {	//방문하지 않았고, 루머를 믿게되는 경우.
					queue.add(new State(next, curr.time + 1));
					time[next] = curr.time + 1;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			bw.write(time[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
