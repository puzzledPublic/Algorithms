package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//친구비
public class BJ16562 {
	static int[] parent;
	static int[] cost;
	static int[] minCost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		cost = new int[N + 1];	//친구비
		minCost = new int[N + 1];	//친구 그룹의 최소 친구비
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			parent[i] = i;
			minCost[i] = cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			union(u, v);	//친구 그룹 만들기
		}
		
		int money = K;
		for(int i = 1; i < N + 1; i++) {
			if(parent[i] == i) {	//부모 루트가 자기자신이면 그룹의 루트를 의미.
				money -= minCost[i];
			}
		}
		
		bw.write((money < 0 ? "Oh no" : (K - money)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int u) {
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static boolean union(int u, int v) {
		if(u < v) {	//u >= v가 되도록.
			int temp = u;
			u = v;
			v = temp;
		}
		
		int r1 = find(u);	//u가 속한 그룹의 루트
		int r2 = find(v);	//v가 속한 그룹의 루트
		
		if(r1 == r2) {
			return false;
		}
		
		//각 그룹의 루트의 값들 중 최소값.
		//r2가 부모 루트가 될 것이므로 r2 위치에 저장.
		minCost[r2] = Math.min(minCost[r2], minCost[r1]);
		
		parent[r1] = r2;
		
		return true;
	}
}
