package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//직사각형 탈출
public class BJ16973 {
	static class Pos {
		int x, y, t;
		Pos(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 for(int j = 1; j <= M; j++) {
				 board[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int Sr = Integer.parseInt(st.nextToken());
		int Sc = Integer.parseInt(st.nextToken());
		int Fr = Integer.parseInt(st.nextToken());
		int Fc = Integer.parseInt(st.nextToken());
		
		int min = -1;
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(Sr, Sc, 0));
		board[Sr][Sc] = 2;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			
			if(p.x == Fr && p.y == Fc) {
				min = p.t;
				break;
			}
			
			for(int h = 0; h < d.length; h++) {
				int nx = p.x + d[h][0], ny = p.y + d[h][1];
				//다음 직사각형 위치가 벽에 걸리는지 확인
				if((0 < nx && nx <= N) && (0 < ny && ny <= M) && (0 < nx + H - 1 && nx + H - 1 <= N) && (0 < ny + W - 1 && ny + W - 1 <= M) && board[nx][ny] == 0) {
					boolean canMove = true;
					for(int i = ny; i < ny + W; i++) {
						if(board[nx][i] == 1 || board[nx + H - 1][i] == 1) {
							canMove = false;
							break;
						}
					}
					for(int i = nx; i < nx + H; i++) {
						if(board[i][ny] == 1 || board[i][ny + W - 1] == 1) {
							canMove = false;
							break;
						}
					}
					if(canMove) {	//움직이는게 가능하면 이동
						board[nx][ny] = 2;
						queue.add(new Pos(nx, ny, p.t + 1));
					}
				}
			}
		}
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
