package baekjoon.bj6000;

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
import java.util.Stack;
import java.util.StringTokenizer;

//숨바꼭질
public class BJ6118 {
	static class State {
		int num, step;
		State(int num, int step) {
			this.num = num;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			graph.get(B).add(A);
		}
		
		int[] chk = new int[N + 1];	//체크 배열 및, 1에서 N까지 최단거리
		Arrays.fill(chk, -1);
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(1, 0));
		chk[1] = 0;
		
		while(!queue.isEmpty()) {	//BFS
			
			State s = queue.poll();
			
			for(int next : graph.get(s.num)) {
				if(chk[next] == -1) {
					chk[next] = s.step + 1;
					queue.add(new State(next, chk[next]));
				}
			}
		}
		
		//가장 긴 최단 거리들을 담는다.
		Stack<Integer> stack = new Stack<>();
		for(int i = 1; i < N + 1; i++) {
			int step = chk[i];
			if(stack.isEmpty()) {
				stack.push(i);
			}else if(chk[stack.peek()] <= step) {
				while(!stack.isEmpty() && chk[stack.peek()] < step) {
					stack.pop();
				}
				stack.push(i);
			}
		}
		//가장 낮은 번호, 최단 거리, 거리가 같은 번호들의 개수
		bw.write(stack.firstElement() + " " + chk[stack.firstElement()] + " " + stack.size());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
