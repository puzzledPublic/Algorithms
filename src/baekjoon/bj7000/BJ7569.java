package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토(동서남북상하)
public class BJ7569 {
	static int count, max;
	static int[][] d = {{0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
	static class Tomato{
		int x, y, h;
		public Tomato(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[N][M][H];
		Queue<Tomato> queue = new LinkedList<>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < M; k++) {
					tomato[j][k][i] = Integer.parseInt(st.nextToken());
					if(tomato[j][k][i] == 0) {
						count++;
					}
					if(tomato[j][k][i] == 1) {
						queue.add(new Tomato(j, k, i));
					}
				}
			}
		}
		if(count == 0) {
			bw.write("0\n");
		}else {
			solve(tomato, queue, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][][] tomato, Queue<Tomato> queue, Writer w) throws IOException {
		int nx, ny, nh;
		Tomato t;
		while(!queue.isEmpty()) {
			t = queue.poll();
			for(int i = 0; i < d.length; i++) {
				nx = t.x + d[i][0];
				ny = t.y + d[i][1];
				nh = t.h + d[i][2];
				if(0 <= nx && nx < tomato.length && 0 <= ny && ny < tomato[0].length && 0 <= nh && nh < tomato[0][0].length) {
					if(tomato[nx][ny][nh] == 0) {
						max = tomato[nx][ny][nh] = tomato[t.x][t.y][t.h] + 1; 
						count--;
						queue.add(new Tomato(nx, ny, nh));
					}
				}
			}
		}
		if(count == 0) {
			w.write((max - 1)+ "\n");
		}else {
			w.write("-1\n");
		}
	}
}
