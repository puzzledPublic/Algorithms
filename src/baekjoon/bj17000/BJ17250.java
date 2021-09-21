package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//은하철도
public class BJ17250 {
	static int N, M;
	static int[] galaxy, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		galaxy = new int[N + 1];
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			galaxy[i] = Integer.parseInt(br.readLine());
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);	//u와 v를 한 그룹으로 묶는다.
			bw.write(galaxy[find(u)] + "\n");	//u가 속한 그룹에서의 root를 찾는다. galaxy[root]가 그룹에 속한 모든 은하의 수의 합.
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//union - find
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void union(int u, int v) {
		int a = find(u);
		int b = find(v);
		
		if(a == b) {
			return;
		}
		
		parent[b] = a;	//a를 b의 부모로..
		galaxy[a] = galaxy[a] + galaxy[b];	//a의 값을 갱신
	}
}
