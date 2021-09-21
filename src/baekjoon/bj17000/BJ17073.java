package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나무 위의 빗물
//모든 빗물은 리프 노드로 가며 이때 모든 리프노드의 기댓값의 합은 W와 같다.
public class BJ17073 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree[U]++;	//트리에서 리프 노드는 이어지는 간선이 하나 뿐이므로 해당 정점에서의 간선 수를 센다.
			tree[V]++;
		}
		
		int leafNode = 0;	//리프 노드의 개수
		for(int i = 2; i < N + 1; i++) {
			if(tree[i] == 1) {	//간선 수가 하나라면 리프 노드
				leafNode++;
			}
		}
		
		bw.write(((double)W / leafNode) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
public class BJ17073 {
	static List<List<Integer>> tree;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList<>();
		chk = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree.get(U).add(V);
			tree.get(V).add(U);
		}
		
		bw.write(((double)W / dfs(1)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dfs(int src) {	//dfs를 통해 리프노드 개수를 반환한다. (위의 풀이보다 시간이 오래걸림)
		chk[src] = true;
		boolean isLeaf = true;
		int leafCount = 0;
		for(int dst : tree.get(src)) {
			if(!chk[dst]) {
				isLeaf = false;
				leafCount += dfs(dst);
			}
		}
		return leafCount + (isLeaf ? 1 : 0);
	}
}*/
