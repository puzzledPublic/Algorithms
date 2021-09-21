package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//사탕 게임
public class BJ3085 {
	static int[][] direction = {{0, 1}, {1, 0}};	//현재 사탕기준 오른쪽, 아래로만 인접한 사탕만 바꿔보면 모든 인접한 사탕을 바꿔보게 된다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][];
		
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < direction.length; k++) {
					int x = i + direction[k][0], y = j + direction[k][1];
					if((0 <= x && x < N) && (0 <= y && y < N)) {
						change(board, i, j, x, y);	//사탕 위치 바꾸기
						int num = howManyCandy(board, i, j, x, y);	//바꿨을때 가장 연속되는 사탕 개수
						if(max < num) {	//최대값 갱신
							max = num;
						}
						change(board, i, j, x, y);	//사탕 위치 복구
					}
				}
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int howManyCandy(char[][] board, int sx, int sy, int dx, int dy) {
		int max;
		if(sx == dx) {	//오른쪽 사탕과 위치를 바꿨을 경우 sy열, dy열, sx행만 검사
			max = Math.max(colCheck(board, sy), Math.max(colCheck(board, dy), rowCheck(board, sx)));
		}else {			//아래쪽 사탕과 위치를 바꿨을 경우 sy열, sx행, dx행만 검사
			max = Math.max(colCheck(board, sy), Math.max(rowCheck(board, sx), rowCheck(board, dx)));
		}
		return max;
	}
	static int rowCheck(char[][] board, int x) {	//행탐색
		char current = board[x][0];
		int max = 1, count = 1;
		for(int i = 1; i < board.length; i++) {
			if(current == board[x][i]) {
				count++;
			}else {
				current = board[x][i];
				if(max < count) {
					max = count;
				}
				count = 1;
			}
		}
		if(max < count) {
			max = count;
		}
		return max;
	}
	static int colCheck(char[][] board, int y) {	//열탐색
		char current = board[0][y];
		int max = 1, count = 1;
		for(int i = 1; i < board.length; i++) {
			if(current == board[i][y]) {
				count++;
			}else {
				current = board[i][y];
				if(max < count) {
					max = count;
				}
				count = 1;
			}
		}
		if(max < count) {
			max = count;
		}
		return max;
	}
	static void change(char[][] board, int sx, int sy, int dx, int dy) {	//인접 사탕 바꾸기
		char temp = board[sx][sy];
		board[sx][sy] = board[dx][dy];
		board[dx][dy] = temp;
	}
}
