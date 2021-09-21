package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//섬의 개수
public class BJ4963 {
	static int[][] d = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			int[][] map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write(solve(map) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int[][] map) {
		int count = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					dfs(map, i, j);
					count++;
				}
			}
		}
		return count;
	}
	static void dfs(int[][] map, int x, int y) {
		for(int i = 0; i < 8; i++) {
			int xx = x + d[i][0];
			int yy = y + d[i][1];
			if((xx >= 0 && xx < map.length) && (yy >= 0 && yy < map[0].length) && map[xx][yy] == 1) {
				map[xx][yy] = 2;
				dfs(map, xx, yy);
			}
		}
	}
}
