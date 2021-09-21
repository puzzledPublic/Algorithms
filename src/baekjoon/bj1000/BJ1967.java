package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//트리의 지름 (BJ1167과 같음)
public class BJ1967 {
	static class Node {
		int index, weight;
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		List<List<Node>> list = new ArrayList<>();
		int[] check = new int[N + 1];	//노드 방문 체크 (weight를 위해 int형)
		
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		StringTokenizer st;
		int parent, child, weight;
		String input;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			parent = Integer.parseInt(st.nextToken());
			child = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list.get(parent).add(new Node(child, weight));	//양방향 연결
			list.get(child).add(new Node(parent, weight));
		}
		solve(list, check, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(List<List<Node>> list, int[] check, Writer w) throws IOException {
		int firstLongestNode = bfs(list, check, 1);	//아무 노드에서 가장 긴 노드를 찾는다
		int longestNode = bfs(list, check, firstLongestNode);	//그 노드에서 다시 가장 긴 노드를 찾는다.
		w.write(check[longestNode] + "\n");
	}
	static int bfs(List<List<Node>> list, int[] check, int root) {
		checkInit(check);	//두번 bfs해야 하므로 체크 배열 초기화
		Queue<Integer> queue = new LinkedList<>();
		int max = 0, longestNode = 1;
		check[root] = 0;
		queue.add(root);
		while(!queue.isEmpty()) {	//bfs 시작
			int index = queue.poll();
			for(Node node : list.get(index)) {
				if(check[node.index] == -1) {
					check[node.index] = check[index] + node.weight;	//전에 탐색한 길이 + 현재 노드까지 길이
					queue.add(node.index);
					if(max < check[node.index]) {	//가장 긴 weight를 찾기위한 로직
						max = check[node.index];
						longestNode = node.index;
					}
				}
			}
		}
		return longestNode;
	}
	static void checkInit(int[] check) {
		for(int i = 1; i < check.length; i++) {
			check[i] = -1;
		}
	}
}
