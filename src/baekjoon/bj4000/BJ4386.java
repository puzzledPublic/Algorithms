package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//별자리 만들기
public class BJ4386 {
	static class Stars {
		int a, b;
		double distance;
		public Stars(int a, int b, double distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		double[][] star = new double[N][N];
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		//소수 둘째자리까지만 나오므로 100을 곱해 정수로 계산하는것도 가능.
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		PriorityQueue<Stars> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				pq.add(new Stars(i, j, getDistance(star[i], star[j])));
			}
		}
		
		
		double cost = 0.0;
		while(!pq.isEmpty()) {
			Stars stars = pq.poll();
			if(union(stars.a, stars.b)) {
				cost += stars.distance;
			}
		}
		
		bw.write(cost + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static double getDistance(double[] a, double[] b) {
		return Math.sqrt((b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]));
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
}