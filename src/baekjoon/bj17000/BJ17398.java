package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//통신망 분할(거꾸로 생각하기)
public class BJ17398 {
	static int[] parent;	//union-find를 위한 배열
	static long[] size;		//i정점이 집합의 루트일때 집합의 크기
	static boolean[] chk;	//처음 단계에 i번째 connection을 만들면 안되는 경우 true
	static int[] query;		//끊어야 할 정점 간 간선을 포함하는 connection 위치
	static int[][] connection;	//정점 간 간선
	static long result;	//Q번 간선을 순서대로 끊었을때 드는 비용의 합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		size = new long[N + 1];
		chk = new boolean[M + 1];
		query = new int[Q];
		connection = new int[M + 1][2];
		
		for(int i = 1; i <= N; i++) {	//union-find를 위해 배열 초기화
			parent[i] = i;
			size[i] = 1;
		}
		
		for(int i = 1; i <= M; i++) {	//connection 입력
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			connection[i][0] = X;
			connection[i][1] = Y;
		}
		
		for(int i = 0; i < Q; i++) {	//query 입력
			query[i] = Integer.parseInt(br.readLine());
			chk[query[i]] = true;		//query[i]번째 connection을 처음에 union 않도록 체크배열에 저장
		}
		
		for(int i = 1; i <= M; i++) {
			if(!chk[i]) {	//chk[i] == false인 경우만 union한다.
				union(connection[i][0], connection[i][1]);
			}
		}
		
		for(int i = Q - 1; i >= 0; i--) {	//query를 거꾸로 돌며 합쳐지는 집합들의 크기의 곱을 더해나간다.
			int u = find(connection[query[i]][0]);
			int v = find(connection[query[i]][1]);
			if(u != v) {
				result += (size[u] * size[v]);
				union(u, v);
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return;
		}
		
		if(u < v) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		parent[u] = v;
		size[v] += size[u];
	}
}