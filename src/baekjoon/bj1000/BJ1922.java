package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//네트워크 연결
public class BJ1922 {
	static class ConnectInfo {
		int a, b, weight;
		public ConnectInfo(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
	}
	//disjoint set을 위한 배열
	static int[] parent;	//자신(i)의 부모를 가르킴
	static int[] rank;		//i로 시작하는 트리의 높이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		
		List<ConnectInfo> list = new ArrayList<>(M);
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new ConnectInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		//가중치대로 오름차순으로 정렬
		Collections.sort(list, (a, b) -> a.weight - b.weight);
		
		//disjoint set을 위한 배열 초기화
		parent = new int[N + 1];
		rank = new int[N + 1];
		for(int i = 1; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		int minWeight = 0;
		for(ConnectInfo ci : list) {	//가중치 순서대로 검사
			int u = ci.a, v = ci.b;		//a, b
			if(find(u) != find(v)) {	//서로 연결돼 있지 않다면
				merge(u, v);			//둘이 연결
				minWeight += ci.weight;	//가중치를 더한다.
			}
		}
		
		bw.write(minWeight + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//부모 찾기 연산
	static int find(int u) {
		if(parent[u] == u) {
			return u;
		}
		
		return parent[u] = find(parent[u]);
	}
	//두 정점 연결 연산
	static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return;
		}
		
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		parent[u] = v;
		
		if(rank[u] == rank[v]) {
			rank[v]++;
		}
	}
}
