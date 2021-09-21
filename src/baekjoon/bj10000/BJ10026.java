package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//적록색약
public class BJ10026 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		char[][] grid = new char[N][];
		boolean[][] chk = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		int normal = 0, colorBlind = 0;		//일반, 적록색약
		//일반 구역 dfs
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!chk[i][j]) {
					normal++;
					solve(grid, chk, i, j, false);
				}
			}
		}
		//체크 배열 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				chk[i][j] = false;
			}
		}
		//적록색약 구역 dfs
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!chk[i][j]) {
					colorBlind++;
					solve(grid, chk, i, j, true);
				}
			}
		}
		
		bw.write(normal + " " + colorBlind + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(char[][] grid, boolean[][] chk, int x, int y, boolean isBlind) {
		chk[x][y] = true;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < grid.length) && (0 <= ny && ny < grid.length) && !chk[nx][ny]) {
				//적록색약인 경우
				if(isBlind && (grid[x][y] == grid[nx][ny] || (grid[x][y] == 'R' && grid[nx][ny] == 'G') || (grid[x][y] == 'G' && grid[nx][ny] == 'R'))) {
					solve(grid, chk, nx, ny, isBlind);
				}else if(grid[x][y] == grid[nx][ny]) {	//일반인 경우
					solve(grid, chk, nx, ny, isBlind);
				}
			}
		}
	}
}
