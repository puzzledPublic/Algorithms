package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//여행가자
public class BJ1976 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	//정점갯수
		int M = Integer.parseInt(br.readLine());	//여행경로상의 정점갯수
		parent = new int[N];	//union - find를 위한 정점의 parent배열
		char[][] cities = new char[N][N];	//연결상태 인접배열 그래프

		for(int i = 0; i < N; i++) {
			parent[i] = i;	//parent배열 초기화
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				cities[i][j] = st.nextToken().charAt(0);	//i <-> j 정점간의 연결 여부
			}
		}

		int[] path = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {	//경로 입력
			path[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cities[i][j] == '1') {	//정점들간에 도달 가능하면 서로 union 한다.
					union(i, j);
				}
			}
		}
		
		String result = "YES\n";
		for(int i = 1; i < M; i++) {
			if(find(path[i]) != find(path[i - 1])) {	//경로상의 정점들이 서로 같은 union안에 없다면 여행경로가 될 수 없다.
				result = "NO\n";
				break;
			}
		}
		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}
	static void union(int a, int b) {
		int v1 = find(a);
		int v2 = find(b);
		
		if(v1 == v2) {
			return;
		}
		parent[v1] = v2;
	}
}
