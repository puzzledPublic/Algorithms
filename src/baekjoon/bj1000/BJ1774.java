package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//우주신과의 교감
public class BJ1774 {
	static class Edge {
		int a, b;
		double len;
		Edge(int a, int b, double len) {
			this.a = a;
			this.b = b;
			this.len = len;
		}
	}
	static int[] parent;
	static List<Edge> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[][] coord = new long[N][2];
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coord[i][0] = Integer.parseInt(st.nextToken());
			coord[i][1] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}

		//모든 정점간 거리 계산
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				list.add(new Edge(i, j, calcLength(coord[i], coord[j])));
			}
		}
		
		//정점 간 거리로 오름차순 정렬
		list.sort((a, b) -> Double.compare(a.len, b.len));
		
		//이미 연결된 곳은 union
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}
		
		double distance = 0.0;	//추가할 통로들 길이의 최소합
		
		//아직 연결 안된 곳을 union
		for(Edge e : list) {
			if(union(e.a, e.b)) {
				distance += e.len;	//최소거리로 통로 연결
			}
		}
		
		bw.write(String.format("%.2f", distance));
		
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
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return false;
		}
		parent[u] = v;
		return true;
	}
	
	static double calcLength(long[] a, long[] b) {
		long x = b[0] - a[0];
		long y = b[1] - a[1];
		return Math.sqrt(x * x + y * y);
	}
}
