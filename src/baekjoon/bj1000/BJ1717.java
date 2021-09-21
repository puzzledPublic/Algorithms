package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//집합의 표현 (disjoint set)
public class BJ1717 {
	static int[] parent;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		rank = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(Integer.parseInt(st.nextToken()) == 0) {
				merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}else {
				if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
					bw.write("YES\n");
				}else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int find(int u) {	//찾기 연산
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	static void merge(int u, int v) {	//합치기 연산
		u = find(u);	//주어진 정점의 루트를 찾는다.
		v = find(v);
		
		if(u == v) {	//루트가 같다면 이미 같은 집합에 속한다.
			return;
		}
		
		if(rank[u] > rank[v]) {	//랭크(트리의 크기)가 더 큰쪽 루트에 랭크가 작은쪽 트리를 연결하도록 한다.
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) {	//랭크가 서로 같다면 한쪽의 랭크는 +1이 되어야한다. 여기서는 루트 u의 부모를 v로 강제하므로 랭크 u의 크기가 1증가한다.
			rank[u]++;
		}
	}
}
