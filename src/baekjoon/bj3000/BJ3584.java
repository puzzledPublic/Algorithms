package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//가장 가까운 공통 조상
public class BJ3584 {
	static int[] depth;		//depth[i] = i 노드의 깊이
	static int[] parent;	//parent[i] = i 노드의 부모노드
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			depth = new int[N + 1];
			parent = new int[N + 1];
			List<List<Integer>> graph = new ArrayList<>();
			for(int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
				parent[i] = i;	//부모 노드를 자기 자신으로 초기화.
			}
			
			for(int i = 1; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int p = Integer.parseInt(st.nextToken());	//부모 노드
				int c = Integer.parseInt(st.nextToken());	//자식 노드
				graph.get(p).add(c);
				parent[c] = p;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			//트리의 root 노드를 찾는다.
			int root = 1;
			while(parent[root] != root) {
				root = parent[root];
			}
			
			//각 노드의 깊이를 매긴다.
			dfs(graph, root, 1);
			
			//같은 깊이가 되도록 만든다.
			while(depth[A] != depth[B]) {
				if(depth[A] < depth[B]) {
					B = parent[B];
				}else {
					A = parent[A];
				}
			}
			
			//서로 같은 부모 또는 같은 노드가 될때까지 깊이를 1씩 올린다.
			while(true) {
				if(parent[A] == parent[B]) { 
					bw.write((A == B ? A : parent[A]) + "\n");
					break;
				}
				A = parent[A];
				B = parent[B];
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(List<List<Integer>> graph, int root, int dep) {
		depth[root] = dep;
		for(int i : graph.get(root)) {
			dfs(graph, i, dep + 1);
		}
	}
}
