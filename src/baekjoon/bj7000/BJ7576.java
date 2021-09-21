package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토(동서남북)
public class BJ7576 {
	static int count, max;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M];
		Queue<Integer> x = new LinkedList<>();
		Queue<Integer> y = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				tomato[i][j] =Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 0) {
					count++;
				}
				if(tomato[i][j] == 1) {
					x.add(i);
					y.add(j);
				}
			}
		}
		if(count == 0) {
			System.out.println(0);
		}else {
			solve(tomato, x, y);
		}
	}
	
	static void solve(int[][] tomato, Queue<Integer> x, Queue<Integer> y) {
		int cx, cy, nx, ny;
		while(!x.isEmpty()) {
			cx = x.poll();
			cy = y.poll();
			for(int i = 0; i < d.length; i++) {
				nx = cx + d[i][0];
				ny = cy + d[i][1];
				if(nx >= 0 && nx < tomato.length && ny >= 0 && ny < tomato[0].length) {
					if(tomato[nx][ny] == 0) {
						max = tomato[nx][ny] = tomato[cx][cy] + 1;
						count--;
						x.add(nx);
						y.add(ny);
					}
				}
			}
		}
		if(count == 0) {
			System.out.println(max - 1);
		}else {
			System.out.println(-1);
		}
	}
}
