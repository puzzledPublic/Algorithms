package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//데스 나이트
public class BJ16948 {
	static class Pos {
		int r, c, t;
		Pos(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static int[][] d = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[N][N];
		
		int time = -1;
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(r1, c1, 0));
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			
			if(p.r == r2 && p.c == c2) {
				time = p.t;
				break;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nr = p.r + d[i][0], nc = p.c + d[i][1];
				if((0 <= nr && nr < N) && (0 <= nc && nc < N) && !check[nr][nc]) {
					check[nr][nc] = true;
					queue.add(new Pos(nr, nc, p.t + 1));
				}
			}
		}
		
		bw.write(time + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
