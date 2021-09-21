package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//도로 네트워크
public class BJ3176 {
	static class Line {
		int vertex, cost;
		public Line(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}
	static int[][] parent;	//parent[i][j] = i 노드의 2^j번째 조상 노드.
	static int[][] min;	//i 노드에서 2^j번째 조상 노드까지 중 최단 간선 거리.
	static int[][] max;	//i 노드에서 2^j번째 조상 노드까지 중 최장 간선 거리.
	static int[] depth;	//i 노드의 깊이
	static List<List<Line>> tree; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		parent = new int[N + 1][18];
		min = new int[N + 1][18];
		max = new int[N + 1][18];
		depth = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
			Arrays.fill(min[i], Integer.MIN_VALUE);
			Arrays.fill(max[i], Integer.MAX_VALUE);
		}
		
		Arrays.fill(depth, -1);
		depth[1] = 1;	//루트는 1로 정한다.
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			tree.get(A).add(new Line(B, C));
			tree.get(B).add(new Line(A, C));
		}
		
		dfs(1);	//노드의 깊이, parent[i][0], min[i][0], max[i][0]를 구한다.
		
		//parent[i][j]를 구한다.
		for(int j = 0; j < 17; j++) {
			for(int i = 1; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					//i 노드의 2^j 높이의 노드는 i에서 2^(j-1) 높이의 노드까지 간 다음 그 노드에서 다시 2^(j-1) 높이를 올라가면 된다. 즉 2^j = 2^(j-1) + 2^(j-1)
					parent[i][j + 1] = parent[parent[i][j]][j];
				}
			}
		}
		
		//min[i][j], max[i][j]를 구한다.
		for(int j = 0; j < 17; j++) {
			for(int i = 1; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					//i 노드에서 2^j+1 높이의 노드까지의 최소 간선 거리는 i 노드에서 2^j 높이의 노드까지의 최단 간선 거리, 그 높이의 노드에서 다시 2^j 높이의 노드까지의 최단 간선 거리 중 짧은 것
					min[i][j + 1] = Math.min(min[i][j], min[parent[i][j]][j]);
					max[i][j + 1] = Math.max(max[i][j], max[parent[i][j]][j]);
				}
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int minCost = Integer.MAX_VALUE, maxCost = Integer.MIN_VALUE;
			
			if(depth[D] < depth[E]) {	//D가 더 깊은 노드를 갖도록.
				int temp = D;
				D = E;
				E = temp;
			}
			
			int diff = depth[D] - depth[E];	//두 노드간 깊이 차이.
			
			for(int j = 0; diff > 0 ; j++) {	//더 깊은 D 노드에서 E 노드 깊이 까지 올라간다.
				if(diff % 2 > 0) {
					minCost = Math.min(minCost, min[D][j]);
					maxCost = Math.max(maxCost, max[D][j]);
					D = parent[D][j];
				}
				diff /= 2;
			}
			
			if(D != E) {	//깊이가 같지만 D와 E 노드가 같은 노드가 아니라면
				for(int j = 17; j >= 0; j--) {	//부모가 같은 노드이면서 최대 깊이가 되도록 올라간다.
					if(parent[D][j] != -1 && parent[D][j] != parent[E][j]) {
						minCost = Math.min(minCost, Math.min(min[D][j], min[E][j]));
						maxCost = Math.max(maxCost, Math.max(max[D][j], max[E][j]));
						D = parent[D][j];
						E = parent[E][j];
					}
				}
				minCost = Math.min(minCost, Math.min(min[D][0], min[E][0]));
				maxCost = Math.max(maxCost, Math.max(max[D][0], max[E][0]));
				D = parent[D][0];
			}
			
			bw.write(minCost + " " + maxCost + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		for(Line sub : tree.get(root)) {
			if(depth[sub.vertex] == -1) {
				depth[sub.vertex] = depth[root] + 1;	//현재 노드의 깊이
				parent[sub.vertex][0] = root;	//현재 노드의 부모 노드
				min[sub.vertex][0] = max[sub.vertex][0] = sub.cost;	//현재 노드와 부모 노드의 최단, 최장 간선 거리
				dfs(sub.vertex);
			}
		}
	}
}
