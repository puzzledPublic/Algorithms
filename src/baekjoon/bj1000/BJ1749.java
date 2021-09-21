package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//점수따먹기
public class BJ1749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//다른 풀이..
		solve2(board);
		
		//board[i][j] = (i, j)까지의 행렬 부분 합
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i - 1 >= 0 && j - 1 >= 0) {
					board[i][j] -= board[i - 1][j - 1];
				}
				if(i - 1 >= 0) {
					board[i][j] += board[i - 1][j];
				}
				if(j - 1 >= 0) {
					board[i][j] += board[i][j - 1];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {	//모든 ixj 부분행렬 합을 비교.
			for(int j = 0; j < M; j++) {
				for(int i2 = 0; i2 < N - i; i2++) {
					for(int j2 = 0; j2 < M - j; j2++) {
						int lr = i2, lc = j2, rr = i2 + i, rc = j2 + j;
						int sum = board[rr][rc];
						if(rr - i - 1 >= 0) {
							sum -= board[rr - i - 1][rc];
						}
						if(rc - j - 1 >= 0) {
							sum -= board[rr][rc - j - 1];
						}
						if(lr - 1 >= 0 && lc - 1 >= 0) {
							sum += board[lr - 1][lc - 1];
						}
						if(max < sum) {
							max = sum;
						}
					}
				}
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//다른 풀이. 아직 이해못함.
	static public void solve2(int[][] board) {
		int N = board.length;
		int M = board[0].length;

		int[][] board2 = new int[N + 1][M + 1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				board2[i][j] = board[i - 1][j - 1];
				board2[i][j] += board2[i - 1][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = i; j < N + 1; j++) {
				int sum = 0;
				for(int k = 1; k < M + 1; k++) {
					if(sum > 0) {
						sum += board2[j][k] - board2[i - 1][k];
					}else {
						sum = board2[j][k] - board2[i - 1][k];
					}
					if(max < sum) {
						max = sum;
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
