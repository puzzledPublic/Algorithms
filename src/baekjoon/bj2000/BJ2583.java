package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//영역 구하기
public class BJ2583 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		int[][] coord = new int[2][2];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 2; j++) {
				coord[j][0] = Integer.parseInt(st.nextToken());
				coord[j][1] = Integer.parseInt(st.nextToken());
			}
			for(int j = coord[0][1]; j < coord[1][1]; j++) {
				for(int k = coord[0][0]; k <coord[1][0]; k++) {
					map[j][k] = true;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!map[i][j]) {
					list.add(solve(map, N, M, i, j));
				}
			}
		}
		
		Collections.sort(list);
		bw.write(list.size() + "\n");
		for(Integer i : list) {
			bw.write(i + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//bfs
	static int solve(boolean[][] map, int n, int m, int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x, y));
		map[x][y] = true;
		int count = 1;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			for(int i = 0; i < d.length; i++) {
				int nx = p.x + d[i][0], ny = p.y + d[i][1];
				if((0 <= nx && nx < n) && (0 <= ny && ny < m) && !map[nx][ny]) {
					map[nx][ny] = true;
					queue.add(new Pos(nx, ny));
					count++;
				}
			}
		}
		return count;
	}
}
