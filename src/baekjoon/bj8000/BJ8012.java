package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//한동이는 영업사원! (LCA)
public class BJ8012 {
	static int[][] parent;	//parent[i][j] = i 정점에서 2^j 높이의 부모 정점
	static int[] depth;	//트리에서 i 정점의 깊이
	static List<List<Integer>> graph = new ArrayList<>();	//트리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1][16];	//N <= 30,000이므로 2^15 = 32,768로 가능.
		depth = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {	//초기화.
			graph.add(new ArrayList<>());
			Arrays.fill(parent[i], -1);
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		depth[1] = 1;	//1 정점을 최상위 루트로 정한다.
		dfs(1);
		
		//parent 배열을 채운다.
		for(int j = 0; j < 15; j++) {
			for(int i = 1; i < N + 1; i++) {
				if(parent[i][j] != -1) {
					parent[i][j + 1] = parent[parent[i][j]][j];
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		int src = 1;
		int total = 0;
		for(int i = 0; i < M; i++) {
			int dst = Integer.parseInt(br.readLine());	//src -> dst까지 거리를 구하자.
			int u = src;
			int v = dst;
			
			int len = 0;	//거리
			if(depth[u] < depth[v]) {	//계산하기 쉽도록 src가 더 깊은 정점이 되도록 만든다.
				int temp = u;
				u = v;
				v = temp;
			}
			
			int diff = depth[u] - depth[v];
			len += diff;
			
			for(int j = 0; diff > 0; j++) {	//src 정점이 dst 정점 깊이까지 오도록 올린다.
				if(diff % 2 > 0) {
					u = parent[u][j];
				}
				diff /= 2;
			}
			
			if(u != v) {	//같은 정점이 아니면
				for(int j = 15; j >= 0; j--) {	//같은 정점이 되기 전까지 두 정점을 올린다.
					if(parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
						u = parent[u][j];
						v = parent[v][j];
						len += Math.pow(2, j + 1);	//두 정점이 같이 올라가므로 길이는 2배 증가
					}
				}
				u = parent[u][0];
				len += 2;	//두 정점(u, v)의 부모 정점이 LCA므로 길이는 2증가
			}
			
			total += len;	//두 정점의 길이를 합산.
			src = dst;
		}
		
		bw.write(total + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		for(int sub : graph.get(root)) {
			if(depth[sub] == 0) {
				depth[sub] = depth[root] + 1;
				parent[sub][0] = root;
				dfs(sub);
			}
		}
	}
}
