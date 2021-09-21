package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//유기농 배추
public class BJ1012 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), M, N, K;
		StringTokenizer st;
		int[][] farm;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			farm = new int[M][N];
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			solve(farm, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//BFS
	static void solve(int[][] farm, Writer w) throws IOException {
		int count = 0;
		for(int i = 0; i < farm.length; i++) {
			for(int j = 0; j < farm[0].length; j++) {
				if(farm[i][j] == 1) {
					Queue<Pos> queue = new LinkedList<>();
					queue.add(new Pos(i, j));
					farm[i][j] = 2;
					while(!queue.isEmpty()) {
						Pos p = queue.poll();
						for(int k = 0; k < d.length; k++) {
							int xx = p.x + d[k][0], yy = p.y + d[k][1];
							if(0 <= xx && xx < farm.length && 0 <= yy && yy < farm[0].length && farm[xx][yy] == 1) {
								farm[yy][xx] = 2;
								queue.add(new Pos(xx, yy));
							}
						}
					}
					count++;
				}
			}
		}
		w.write(count + "\n");
	}
}
