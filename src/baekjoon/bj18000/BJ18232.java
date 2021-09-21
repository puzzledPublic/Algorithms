package baekjoon.bj18000;

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

//텔레포트 정거장
public class BJ18232 {
	static class State {
		int pos, time;
		State(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	static boolean[] check;
	static List<List<Integer>> graph = new ArrayList<>();
	static int N, M, S, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	//전체 길이
		M = Integer.parseInt(st.nextToken());	//텔레포트 개수
		
		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());	//시작점
		E = Integer.parseInt(st.nextToken());	//도착점
		
		check = new boolean[N + 1];	//BFS를 위한 방문체크 배열
		
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {	//텔레포트 경로
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(S, 0));
		
		while(!queue.isEmpty()) {	//BFS
			State state = queue.poll();
			
			if(state.pos == E) {	//도착점 도착시 시간 출력
				bw.write(state.time + "\n");
				break;
			}
			
			if(state.pos + 1 <= N && !check[state.pos + 1]) {	//X + 1로 이동
				check[state.pos + 1] = true;
				queue.add(new State(state.pos + 1, state.time + 1));
			}
			
			if(state.pos - 1 > 0 && !check[state.pos - 1]) {	//X - 1로 이동
				check[state.pos - 1] = true;
				queue.add(new State(state.pos - 1, state.time + 1));
			}
			
			for(int teleport : graph.get(state.pos)) {	//텔레포트로 이동
				if(!check[teleport]) {
					check[teleport] = true;
					queue.add(new State(teleport, state.time + 1));
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
