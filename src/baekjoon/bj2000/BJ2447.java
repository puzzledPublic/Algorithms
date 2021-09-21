package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//별찍기 10
public class BJ2447 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		for(int i = 0; i < N; i++) {	//빈 문자로 초기화
			for(int j = 0; j < N; j++) {
				board[i][j] = ' ';
			}
		}
		if(N == 1) {
			bw.write("*\n");
		}else {
			solve(board, N, 0, 0);
			for(int i = 0; i < N; i++) {
				bw.write(board[i]);
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(char[][] board, int n, int x, int y) {
		if(n == 3) {
			for(int i = x; i < x + 3; i++) {
				for(int j = y; j < y + 3; j++) {
					board[i][j] = '*';
				}
			}
			board[x + 1][y + 1] = ' ';
			return;
		}else {
			int next = n / 3;
			solve(board, next, x, y);
			solve(board, next, x, y + next);
			solve(board, next, x, y + next * 2);
			solve(board, next, x + next, y);
			solve(board, next, x + next, y + next * 2);
			solve(board, next, x + next * 2, y);
			solve(board, next, x + next * 2, y + next);
			solve(board, next, x + next * 2, y + next * 2);
		}
	}
}
