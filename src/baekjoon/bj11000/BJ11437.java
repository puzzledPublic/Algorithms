package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//LCA
public class BJ11437 {
	static int[][] parent;	//parent[u][k] = 정점 u의 2^k번째 부모정점을 나타낸다.
	static int[] depth;		//depth[u] = 정점 u의 높이
	static int pDepth = 17;	//정점 N개가 있을때 min(2^k) >= N 인  pDepth = k + 1
	static List<List<Integer>> list;	//트리를 나타낼 인접리스트
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>(N + 1);
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		list.get(0).add(1);		//실제 루트는 1이지만 가상의 최상단 루트 0이 있다고 설정.
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		parent = new int[N + 1][pDepth];
		depth = new int[N + 1];
		
		Arrays.fill(depth, -1);	//배열 초기화
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
		}
		
		depth[0] = 0;	//가상 루트 0의 높이는 0
		dfs(0);	//루트를 돌며 각 정점의 높이와
		
		//DP로 각 정점의 2^k번째 부모 정점을 알아낸다. 2^(k+1) = 2^k + 2^k -> parent[u][k + 1] = parent[parent[u][k]][k]
		for(int i = 0; i < pDepth; i++) {
			for(int j = 0; j < parent.length; j++) {
				if(parent[j][i] != -1) {
					parent[j][i + 1] = parent[parent[j][i]][i];
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());		//LCA를 알고 싶은 두 정점 u, v
			
			if(depth[u] < depth[v]) {	//depth[u] >= depth[v]를 강제한다.
				int temp = u;
				u = v;
				v = temp;
			}
			
			int diff = depth[u] - depth[v];	//두 정점 높이간의 차이
			
			for(int j = 0; diff > 0; j++) {	//미리구한 parent[u][k]를 사용해 높이 차이만큼 정점 u를 v높이까지 올린다.
				if(diff % 2 > 0) {			//ex)diff = 11일때 2진수로는 1011이고 이는 2^0번째 부모정점 -> 2^1번째 부모정점 ->2^3번째 부모정점으로 이동을 나타낸다.
					u = parent[u][j];
				}
				diff /= 2;
			}
			
			if(u != v) {	//두 정점간 높이를 맞췄는데 아직 LCA가 아니라면.
				for(int j = pDepth - 1; j >= 0; j--) {	
					if(parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
						u = parent[u][j];
						v = parent[v][j];
					}
				}
				u = parent[u][0];
			}
			
			bw.write(u + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		for(int next : list.get(root)) {
			if(depth[next] == -1) {
				depth[next] = depth[root] + 1;
				parent[next][0] = root;
				dfs(next);
			}
		}
	}
}
