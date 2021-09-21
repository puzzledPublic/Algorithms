package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나이트의 이동
public class BJ7562 {
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] D = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken()), sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int dx = Integer.parseInt(st.nextToken()), dy = Integer.parseInt(st.nextToken());
			if(sx == dx && sy == dy) {
				bw.write("0\n");
			}else {
				bw.write(solve(N, sx, sy, dx, dy) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int N, int sx, int sy, int dx, int dy) {
		int[][] map = new int[N][N];
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(sx, sy));
		map[sx][sy] = 1;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			for(int i = 0; i < D.length; i++) {
				int xx = p.x + D[i][0], yy = p.y + D[i][1];
				if((0 <= xx && xx < N) && (0 <= yy && yy < N) && map[xx][yy] == 0) {
					if(xx == dx && yy == dy) {
						return map[p.x][p.y];
					}
					map[xx][yy] = map[p.x][p.y] + 1;
					queue.add(new Pos(xx, yy));
				}
			}
		}
		return 0;
	}
}
