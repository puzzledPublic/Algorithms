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

//트리의 지름
//아무 정점 a에서 시작해서 가장 긴 경로를 가진 정점을 찾는다.
//그 정점에서 다시 가장 긴 경로를 찾으면 트리의 지름이 된다.
public class BJ1167 {
	static class Node { 
		int node, weight;
		public Node(int vertex, int weight) {
			this.node = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int V = Integer.parseInt(br.readLine());
		
		int[] check = new int[V + 1];
		List<List<Node>> lists = new ArrayList<>();
		for(int i = 0; i < V + 1; i++) {
			lists.add(new LinkedList<>());
		}

		List<Node> v;
		int node, weight;
		StringTokenizer st;
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			v = lists.get(Integer.parseInt(st.nextToken())); 
			while((node = Integer.parseInt(st.nextToken())) != -1) {
				weight = Integer.parseInt(st.nextToken());
				v.add(new Node(node, weight));
			}
		}
		solve(lists, check, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<List<Node>> lists, int[] check, Writer w) throws IOException {
		int firstLongestNode = bfs(lists, check, 1); //아무 정점 선택하여 가장 긴 경로를 갖는 정점을 찾는다.
		int secondLongestNode = bfs(lists, check, firstLongestNode);	//그 정점에서 다시 가장 긴 경로를 갖는 정점을 찾는다.
		w.write(check[secondLongestNode] + "\n");
	}
	
	static int bfs(List<List<Node>> lists, int[] check, int root) {
		for(int i = 1; i < check.length; i++) {	//bfs를 여러번 해야하므로 check배열 초기화ㅏ
			check[i] = -1;	//-1이면 방문 안됨
		}
		Queue<Integer> queue = new LinkedList<>();
		check[root] = 0;	//자기 자신은 경로 길이가 0
		queue.add(root);
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(Node p : lists.get(n)) {
				if(check[p.node] == -1) {
					check[p.node] = check[n] + p.weight;	//전까지 방문한 노드의 길이 + 현재 방문하는 노드의 길이
					queue.add(p.node);
				}
			}
		}
		int max = 0, longestNode = 1;
		for(int i = 1; i < check.length; i++) {	//root에서 시작하는 모든 정점간의 거리 중 가장 긴 경로 및 정점 선택
			if(max < check[i]) {
				max = check[i];
				longestNode = i;
			}
		}
		return longestNode;
	}
}
