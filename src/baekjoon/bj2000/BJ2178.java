package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로 탐색
public class BJ2178 {
	static int max;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		map[0][0] = 2;	//2는 시작점, 1은 갈 수 있는곳
		solve(map);
		System.out.println(max - 1);
		br.close();
	}
	
	static void solve(int[][] map) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0));
		int x, y;
		Pos p;
		while(!queue.isEmpty()) {
			p = queue.poll();
			for(int i = 0; i < d.length; i++) {
				x = p.x + d[i][0];
				y = p.y + d[i][1];
				if(0 <= x && x < map.length && 0 <= y && y < map[0].length) {
					if(map[x][y] == 1) {
						map[x][y] = map[p.x][p.y] + 1;
						if(x == map.length - 1 && y == map[0].length - 1) {	//map[N][M]에 도착했으면
							max = map[x][y];
							return;
						}
						queue.add(new Pos(x, y));
					}
				}
			}
		}
	}
}
