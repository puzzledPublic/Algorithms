package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//LCA
//기본 알고리즘 
//1. 두 정점의 높이를 구한다.
//2. 두 정점 중 더 긴 높이의 정점을 낮은 높이의 정점만큼 부모 정점으로 이동시킨다.
//3. 두 정점이 같아질때까지 부모 정점으로 이동한다.
public class LowestCommonAncestor {
	
	static int[][] parent = new int[16][5];	//parent[u][k] = 정점 u의 2^k번째 부모 정점
	static int[] depth = new int[16];	//정점 u의 높이
	static List<List<Integer>> list = new ArrayList<List<Integer>>();	//트리 인접 리스트
	public static void main(String[] args) {
		int N = 15, M = 6;
		int[][] treeInfo = {
				{1, 2}, {1, 3}, {2, 4}, {3, 7}, {6, 2}, {3, 8}, {4, 9}, {2, 5}, {5, 11}, {7, 13}, {10, 4}, {11, 15}, {12, 5}, {14, 7},
		};
		int[][] wantToKnow = {
				{6, 11}, {10, 9}, {2, 6}, {7, 6}, {8, 13}, {8, 15},
		};
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		list.get(0).add(1);
		for(int i = 0; i < N - 1; i++) {
			list.get(treeInfo[i][0]).add(treeInfo[i][1]);
			list.get(treeInfo[i][1]).add(treeInfo[i][0]);
		}
		
		Arrays.fill(depth, -1);
		for(int i = 0; i < parent.length; i++) {
			Arrays.fill(parent[i], -1);
		}
		
		depth[0] = 0;	//0이 최상단 루트라 가정
		dfs(0);	//트리 각 정점의 depth와 부모 정점을 구함
		
		//DP로 
		for(int i = 0; i < 5; i++) {
			for(int j = 1; j < parent.length; j++) {
				if(parent[j][i] != -1) {
					parent[j][i + 1] = parent[parent[j][i]][i];
				}
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < parent.length; j++) {
				System.out.print(parent[j][i] < 0 || parent[j][i] > 9 ? parent[j][i] : " " + parent[j][i]);
			}
			System.out.println();
		}
		
		for(int i = 0; i < M; i++) {
			int u = wantToKnow[i][0], v = wantToKnow[i][1];	//구하고자 하는 LCA(u, v)
			
			if(depth[u] < depth[v]) {	//depth[u] >= depth[v]를 강제한다.
				int temp = u;
				u = v;
				v = temp;
			}
			
			int diff = depth[u] - depth[v];	//정점 u와 v depth 차이
			
			for(int j = 0; diff > 0; j++) {	//depth 차이만큼 다음 부모 정점 올리는게 아닌 DP로 구해놓은 배열을 통해 logn만에 부모 정점으로 이동시킨다. 
				if(diff % 2 > 0) {			//(ex 11인 경우 2진수로 1011이고 이는 2^0(1)번째 부모 정점으로 이동 -> 2^1(2)번째 부모 정점 -> 2^3(8)번째 부모 정점으로 이동하면 원래 정점에서 높이 11만큼 이동한게 된다.)
					u = parent[u][j];
				}
				diff /= 2;
			}
			
			if(u != v) {	//두 정점의 depth가 같지만 LCA가 아니라면
				for(int j = 5 - 1; j >= 0; j--) {	//가장 높은 부모 정점부터 시작해서 부모가 다르다면 각각의 부모로 정점을 이동시키고 거기서 또 부모 정점이 같은지 시도해본다.
					if(parent[u][j] != -1 && parent[u][j] != parent[v][j]) {
						u = parent[u][j];
						v = parent[v][j];
					}
				}
				u = parent[u][0];	//u와 v의 부모 정점이 같으므로 LCA를 위해 u를 부모 정점으로 이동
			}
			System.out.println(u);
		}
	}
	
	static void dfs(int root) {
		for(int next : list.get(root)) {
			if(depth[next] == -1) {
				parent[next][0] = root;
				depth[next] = depth[root] + 1;
				dfs(next);
			}
		}
	}
}
