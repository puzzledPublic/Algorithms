package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다리 만들기2
public class BJ17472 {
	static class Bridge {
		int a, b, cost;
		public Bridge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] chk;
	static int[] parent;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		chk = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 1;
		for(int i = 0; i < N; i++) {	//맵을 돌면서 섬을 구분한다.
			for(int j = 0; j < M; j++) {
				if(!chk[i][j] && map[i][j] == 1) {
					dfs(i, j, count++);
				}
			}
		}
		
		PriorityQueue<Bridge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);	//섬들 간의 다리 건설 비용
		
		for(int i = 0; i < N; i++) {	//맵을 돌면서
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {	//섬지역이면
					for(int k = 0; k < d.length; k++) {	//각 상,하,좌,우에 대해 직선으로 연결되는 다리가 있는지 검사.
						int nx = i + d[k][0], ny = j + d[k][1];
						int cc = 0;
						while((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
							if(map[nx][ny] == map[i][j]) {	//다음 지역이 같은 섬이라면 종료
								break;
							}else if(map[nx][ny] > 0) {	//다른 섬이라면 다리 건설 가능
								if(cc > 1) {	//다리 길이는 2이상이어야한다.
									pq.add(new Bridge(map[i][j], map[nx][ny], cc));
								}
								break;
							}
							nx += d[k][0];
							ny += d[k][1];
							cc++;
						}
					}
				}
			}
		}
		
		//MST를 구해야하므로 union-find를 한다.
		parent = new int[count];	//union-find를 위한 배열
		for(int i = 0; i < count; i++) {
			parent[i] = i;
		}
		
		int cost = 0;
		while(!pq.isEmpty()) {
			Bridge bg = pq.poll();
			if(union(bg.a, bg.b)) {	//연결 가능하면 연결
				cost += bg.cost;
			}
		}
		
		//이전에 단순히 union할때 bg.a, bg.b에 대해 체크배열에 체크만 하고 체크된 섬들개수가 count-1개면 출력했더니 예외가있었다.
		//count-1 = 7이고 1-2, 4-5, 2-3, 2-6이라면 모든 섬이 체크 되지만 정작 연결된 섬은 1-2-3-6, 4-5가 되는 경우가 있다.
		//그래서 find로 같은 집합에 있는지 검사하도록 만들었다.
		int root = find(1);
		for(int i = 2; i < count; i++) {
			if(root != find(i)) {
				root = -1;
				break;
			}
		}
		
		bw.write((root != -1 ? cost : -1) + "\n");	//모든 섬이 연결 됐다면 cost, 아니라면 -1 출력
		
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
	
	static void dfs(int x, int y, int n) {
		map[x][y] = n;	//n번째섬의 일부
		chk[x][y] = true;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && !chk[nx][ny] && map[nx][ny] != 0) {
				dfs(nx, ny, n);
			}
		}
	}
}
