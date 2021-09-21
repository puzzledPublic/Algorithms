package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//현수막 (flood fill)
public class BJ14716 {
	static char[][] board;
	static int M, N;
	static int[][] d = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[M][N];
		for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 for(int j = 0; j < N; j++) {
				 board[i][j] = st.nextToken().charAt(0);
			 }
		}
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == '1') {
					count++;
					dfs(i, j);
				}
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void dfs(int x, int y) {
		board[x][y] = '0';
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < M) && (0 <= ny && ny < N) && board[nx][ny] == '1') {
				dfs(nx, ny);
			}
		}
	}
}
