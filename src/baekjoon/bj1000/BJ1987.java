package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//알파벳
public class BJ1987 {
	static boolean[] alphabet = new boolean[26];
	static int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[][] board =  new char[R][];
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		alphabet[board[0][0] - 'A'] = true;
		bw.write(solve(board, 0, 0, 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(char[][] board, int x, int y, int step) {
		int result = step;
		for(int i = 0; i < d.length; i++) {
			int xx = x + d[i][0], yy = y + d[i][1];
			if((0 <= xx && xx < board.length) && (0 <= yy && yy < board[0].length) && !alphabet[board[xx][yy] - 'A']) {
				alphabet[board[xx][yy] - 'A'] = true;
				result = Math.max(result, solve(board, xx, yy, step + 1));
				alphabet[board[xx][yy] - 'A'] = false;
			}
		}
		return result;
	}
}
