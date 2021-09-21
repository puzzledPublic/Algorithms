package kakao.kakao2020.intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//동굴 탐험
public class Caving {
	public static void main(String[] args) {
		int[] n = { 9, 9, 9, 9, 6 };
		int[][][] path = { 
				{ { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } },
				{ { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } },
				{ { 8, 1 }, { 0, 1 }, { 1, 2 }, { 0, 7 }, { 4, 7 }, { 0, 3 }, { 7, 5 }, { 3, 6 } },
				{ { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } },
				{ { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 } },
				};
		int[][][] order = {
				{ { 3, 5 }, { 6, 7 } }, 			//true
				{ { 8, 5 }, { 6, 7 }, { 4, 1 } }, 	//true
				{ { 4, 1 }, { 5, 2 } },				//true
				{ { 4, 1 }, { 8, 7 }, { 6, 5 } }, 	//false
				{ { 3, 2 }, { 5, 1 } },				//true
				};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], path[i], order[i]));
		}
	}

	static List<List<Integer>> tree;
	static List<List<Integer>> graph;
	static boolean[] check;
	static boolean[] onGoing;
	static int[] nextIndex;
	static boolean cycle;
	static boolean solution(int n, int[][] path, int[][] order) {
		boolean answer = true;
		
		tree = new ArrayList<>();
		graph = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
			graph.add(new ArrayList<>());
		}
		
		check = new boolean[n];
		onGoing = new boolean[n];
		nextIndex = new int[n];
		
		for(int i = 0; i < n - 1; i++) {
			tree.get(path[i][0]).add(path[i][1]);
			tree.get(path[i][1]).add(path[i][0]);
		}
		
		dfs(0);
		
		for(int i = 0; i < order.length; i++) {
			graph.get(order[i][0]).add(order[i][1]);
		}
		
		Arrays.fill(check, false);
		Arrays.fill(onGoing, false);
		
		cycle = false;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		while(!stack.isEmpty()) {
			int curr = stack.peek();
			check[curr] = onGoing[curr] = true;
			boolean noLeft = true;
			for(int i = nextIndex[curr]; i < graph.get(curr).size(); i++) {
				int next = graph.get(curr).get(i);
				if(!check[next]) {
					nextIndex[curr] = i + 1;
					stack.push(next);
					noLeft = false;
					break;
				}else if(onGoing[next]) {
					cycle = true;
					break;
				}
			}
			if(noLeft) {
				onGoing[curr] = false;
				stack.pop();
			}
			if(cycle) break;
		}
		
		return answer = !cycle;
	}
	
	static void dfs(int root) { 
		check[root] = true;
		for(int next : tree.get(root)) {
			if(!check[next]) {
				graph.get(root).add(next);
				dfs(next);
			}
		}
	}
}
