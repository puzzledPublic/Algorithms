package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//행성 터널
public class BJ2887 {
	static class Edge {
		int u, v, w;
		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	static class Star {
		int n, x, y, z;
		Star(int n, int x, int y, int z) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int[] parent;
	static List<Edge> edgeList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Star> list = new ArrayList<>();
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Star(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			parent[i] = i;
		}
		
		list.sort((a, b) -> a.x - b.x);	//x축에 대해 오름차순 정렬
		for(int i = 1; i < list.size(); i++) {
			int u = list.get(i - 1).n;
			int v = list.get(i).n;
			int w = list.get(i).x - list.get(i - 1).x;	//모든 행성간 거리를 살펴 볼 필요가 없다. 인접한 행성끼리의 x값 차이의 절대값이 최소가 된다. (아래 y, z도 마찬가지) 
			edgeList.add(new Edge(u, v, w));
		}
		
		list.sort((a, b) -> a.y - b.y);	//y축에 대해 오름차순 정렬
		for(int i = 1; i < list.size(); i++) {
			int u = list.get(i - 1).n;
			int v = list.get(i).n;
			int w = list.get(i).y - list.get(i - 1).y;
			edgeList.add(new Edge(u, v, w));
		}
		
		list.sort((a, b) -> a.z - b.z);	//z축에 대해 오름차순 정렬
		for(int i = 1; i < list.size(); i++) {
			int u = list.get(i - 1).n;
			int v = list.get(i).n;
			int w = list.get(i).z - list.get(i - 1).z;
			edgeList.add(new Edge(u, v, w));
		}
		
		edgeList.sort((a, b) -> a.w - b.w);
		
		int result = 0;
		for(Edge e : edgeList) {	//크루스칼.
			if(union(e.u, e.v)) {
				result += e.w;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//union - find
	static int find(int u) {
		if(parent[u] == u) {
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
}
