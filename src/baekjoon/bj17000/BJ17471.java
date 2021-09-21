package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//게리맨더링
public class BJ17471 {
	static int N, C, Min = Integer.MAX_VALUE;
	static boolean chk[];
	static int[] people;
	static int parent[];
	static boolean[][] graph; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new boolean[N + 1][N + 1];
		chk = new boolean[N + 1];
		people = new int[N + 1];
		parent = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {	//그래프 생성
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= M; j++) {
				int k = Integer.parseInt(st.nextToken());
				graph[i][k] = graph[k][i] = true;
			}
		}
		//N개중 1 ~ N/2개를 고르는 경우를 모두 수행
		for(int i = 1; i <= N / 2; i++) {
			C = i + 1;
			select(1, 0);
		}
		
		bw.write((Min == Integer.MAX_VALUE ? "-1\n" : Min + "\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return;
		}
		parent[u] = v;
	}
	
	static boolean can(List<Integer> list) {	//마을들이 한 구역에 속할 수 있는지 검사
		boolean allPass = true;
		if(list.size() == 1) {	//한 구역에 마을이 1개인 경우
			return true;
		}
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < list.size(); i++) {	//union-find로 집합을 만들어본다.
			for(int j = 0; j < list.size(); j++) {
				if(i != j) {
					int a1 = list.get(i), a2 = list.get(j);
					if(graph[a1][a2]) {	//두 마을간 길이 있다면 union
						union(a1, a2);
					}
				}
			}
		}
		int root = find(parent[list.get(0)]);	//각 마을들이 모두 하나의 집합에 속하면 한 구역을 이룰 수 있다.
		for(int i = 1; i < list.size(); i++) {
			if(root != find(parent[list.get(i)])) {
				allPass = false;
				break;
			}
		}
		
		return allPass;
	}
	//마을이 N = 2 ~ 10개이므로 N개중 1 ~ N/2개만 고르면 모든 경우를 탐색해 볼 수 있다.
	static void select(int n, int next) {
		if(n == C) {	//A구역에 해당되는 n개 마을을 골랐으면
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for(int i = 1; i <= N; i++) {	//A, B 구역에 속하는 마을 번호 리스트를 만든다.
				if(chk[i]) {
					A.add(i);
				}else {
					B.add(i);
				}
			}
			
			if(can(A) && can(B)) {	//A, B 각 구역에 대해 마을끼리 모두 도달 가능하면
				int sumA = 0, sumB = 0;	//A, B 각 구역의 인구수를 센다.
				for(int i : A) {
					sumA += people[i];
				}
				for(int i : B) {
					sumB += people[i];
				}
				
				int diff = Math.abs(sumA - sumB);	//두 구역간 인구수 차이가 최소가 되도록 갱신.
				if(Min > diff) {
					Min = diff;
				}
			}
			return;
		}
		for(int i = next + 1; i <= N; i++) {
			chk[i] = true;
			select(n + 1, i);
			chk[i] = false;
		}
	}
}
