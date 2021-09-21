package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Count Circle Group
public class BJ10216 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()), N;
		int[][] circle;
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N];
			circle = new int[N][3];
			for(int j = 0; j < N; j++) {
				parent[j] = j;
				st = new StringTokenizer(br.readLine(), " ");
				circle[j][0] = Integer.parseInt(st.nextToken());
				circle[j][1] = Integer.parseInt(st.nextToken());
				circle[j][2] = Integer.parseInt(st.nextToken());
				for(int k = j - 1; k >= 0; k--) {	//현재 입력 좌표와 그전에 입력받은 좌표들과 비교
					if(isConnected(circle[j][0], circle[j][1], circle[j][2], circle[k][0], circle[k][1], circle[k][2])) {	//두 좌표의 범위가 서로 접하거나 겹친다면
						merge(j, k);	//서로 하나의 집합으로 만든다
					}
				}
			}
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(parent[j] == j) {		//루트가 자기 자신이면 집합 하나가 존재함
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int find(int u) {	//disjoint set 찾기 연산
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	static void merge(int u, int v) {	//합치기 연산
		u = find(u);
		v = find(v);
		if(u == v) {
			return;
		}
		parent[u] = v;
	}
	static boolean isConnected(int x1, int y1, int r1, int x2, int y2, int r2) {	//두 원이 접하거나 겹치는 경우 = sqrt(|x2 - x1|^2 + |y2 - y1|^2) <= r1 + r2
		//int x = Math.abs(x2 - x1);
		//int y = Math.abs(y2 - y1);
		//return Math.sqrt(x * x +y * y) <= (r1 + r2) ? true : false;	//abs, sqrt 사용시 시간이 더 걸림
		int x = x2 - x1, y = y2 - y1, z = r1 + r2;
		return x * x + y * y <= z * z ? true : false;
	}
}
