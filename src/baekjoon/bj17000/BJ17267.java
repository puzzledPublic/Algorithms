package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상남자
public class BJ17267 {
	static class Pos{
		int x, y, l, r;
		Pos(int x, int y, int l, int r) {
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		Queue<Pos> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '2') {
					map[i][j] = '1';
					queue.add(new Pos(i, j, L, R));
				}
			}
		}
		int result = 0;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			
			result++;
			
			int nx = p.x, ny = p.y;
			while(nx + 1 < N && map[nx + 1][ny] == '0') {
				map[nx + 1][ny] = '1';
				queue.add(new Pos(nx + 1, ny, p.l, p.r));
				nx++;
			}
			nx = p.x;
			while(nx - 1 >= 0 && map[nx - 1][ny] == '0') {
				map[nx - 1][ny] = '1';
				queue.add(new Pos(nx - 1, ny, p.l, p.r));
				nx--;
			}
			
			nx = p.x;
			ny = p.y + 1;
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && map[nx][ny] == '0') {
				if(p.r > 0) {
					map[nx][ny] = '1';
					queue.add(new Pos(nx, ny, p.l, p.r - 1));
				}
			}
			nx = p.x;
			ny = p.y - 1;
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && map[nx][ny] == '0') {
				if(p.l > 0) {
					map[nx][ny] = '1';
					queue.add(new Pos(nx, ny, p.l - 1, p.r));
				}
			}
//			for(int i = 0; i < d.length; i++) {
//				int nx = p.x + d[i][0], ny = p.y + d[i][1];
//				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && map[nx][ny] == '0') {
//					if(i == 0 && p.r > 0) {
//						map[nx][ny] = '1';
//						queue.add(new Pos(nx, ny, p.l, p.r - 1));
//					}else if(i == 2 && p.l > 0) {
//						map[nx][ny] = '1';
//						queue.add(new Pos(nx, ny, p.l - 1, p.r));
//					}else if(i == 1 || i == 3) {
//						map[nx][ny] = '1';
//						queue.add(new Pos(nx, ny, p.l, p.r));
//					}
//				}
//			}
		}
		
		bw.write(result + "\n");
	
		bw.flush();
		br.close();
		br.close();
	}
}
