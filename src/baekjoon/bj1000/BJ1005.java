package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//ACM craft
public class BJ1005 {
	static int T, N, K, W;	//테스트 케이스, 건물 갯수, 건물 규칙 갯수, 목적 정점
	static int[] cost, indegree;	//건물 비용, 각 정점의 들어오는 간선 갯수
	static Map<Integer, List<Integer>> graph;	//각 정점에서 이어지는 정점들을 리스트에 저장
	static int[] DT;	//동적 테이블
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(input.readLine());
		for(int i = 0; i < T; i++) {
			String[] NK = input.readLine().split(" ");
			N = Integer.parseInt(NK[0]);
			K = Integer.parseInt(NK[1]);
			cost = new int[N + 1];
			indegree = new int[N + 1];
			graph = new HashMap<>();
			DT = new int[N + 1];

			String[] costs = input.readLine().split(" ");
			for(int j = 1; j < N + 1; j++) {
				cost[j] = Integer.parseInt(costs[j - 1]);
			}
			String[] ab;
			/*for(int j = 0; j < K; j++) {
				ab = input.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				if(graph.get(b) == null) {
					graph.put(b, new LinkedList<>());
				}
				graph.get(b).add(a);	//a -> b로 가는 규칙들을 목적 정점에서 거꾸로 dfs하기 위하여 b -> a 식으로 저장
			}*/
			for(int j = 0; j < K; j++) {
				ab = input.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				if(graph.get(a) == null) {
					graph.put(a, new LinkedList<>());
				}
				graph.get(a).add(b);
				indegree[b]++;	
			}
			W = Integer.parseInt(input.readLine());
			solve();
		}
	}
	static void solve() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				DT[i] = cost[i];
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int v = queue.poll();
			List<Integer> list = graph.get(v);
			if(list == null) {
				continue;
			}
			for(Integer i : list) {
				DT[i] = Math.max(DT[i], DT[v] + cost[i]);
				if(--indegree[i] == 0) { //현재 정점이랑 연결된 다음 정점이 간선 하나로 연결됐다면 큐에 추가
					queue.add(i);
				}
			}
		}
		System.out.println(DT[W]);
	}
	
	//time out
/*	static Stack<Integer> dfs() {	//목적 정점부터 거꾸로 dfs하여 위상정렬 스택에 저장
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		queue.add(W);
		stack.push(W);
		while(!queue.isEmpty()) {
			int index = queue.poll();
			List<Integer> list = graph.get(index);
			if(list != null) {
				for(Integer i : list) {
					if(stack.contains(i)) {
						stack.remove(i);
					}
					stack.push(i);
					queue.add(i);
				}
			} else {
				stack.push(index);
			}
		}
		return stack;
	}
	static void solve() {	//스택에서 정점들을 꺼내 동적계획법으로 푼다.
		Stack<Integer> stack = dfs();
		while(!stack.isEmpty()) {
			int index = stack.pop();
			int temp = 0;
			List<Integer> list = graph.get(index);
			if(list != null) {	
				for(Integer i : list) {
					DT[index] = Math.max(temp, DT[i]) + cost[index];
					temp = DT[i];
				}
			}else {
				DT[index] = cost[index];
			}
		}
		System.out.println(DT[W]);
	}*/
}