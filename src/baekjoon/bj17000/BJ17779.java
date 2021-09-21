package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//게리맨더링2
public class BJ17779 {
	static int N, SUM, D, MIN = Integer.MAX_VALUE;
	static int[][] city;
	static int[][] board;
	static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		D = N / 2;
		city = new int[N + 1][N + 1];
		board = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				SUM += city[i][j];
			}
		}
		
		for(int d1 = 1; d1 <= D; d1++) {
			for(int d2 = 1; d2 <= D; d2++) {
				for(int x = 1; x <= N - d1 - d2; x++) {
					for(int y = 1 + d1; y <= N - d2; y++) {
						//1
						for(int i = 1; i < x + d1; i++) {
							for(int j = 1; j <= y; j++) {
								board[i][j] = 1;
							}
						}
						//2
						for(int i = 1; i <= x + d2; i++) {
							for(int j = y + 1; j <= N; j++) {
								board[i][j] = 2;
							}
						}
						//3
						for(int i = x + d1; i <= N; i++) {
							for(int j = 1; j < y - d1 + d2; j++) {
								board[i][j] = 3;
							}
						}
						//4
						for(int i = x + d2 + 1; i <= N; i++) {
							for(int j = y - d1 + d2; j <= N; j++) {
								board[i][j] = 4;
							}
						}
						//5
						for(int i = 0; i <= d1; i++) {
							board[x + i][y - i] = 5;
						}
						for(int i = 0; i <= d2; i++) {
							board[x + i][y + i] = 5;
						}
						for(int i = 0; i <= d2; i++) {
							board[x + d1 + i][y - d1 + i] = 5;
						}
						for(int i = 0; i <= d1; i++) {
							board[x + d2 + i][y + d2 - i] = 5;
						}
						//dfs
						int[] people = new int[5];
						people[0] = dfs(1, 1, 1);
						people[1] = dfs(1, N, 2);
						people[2] = dfs(N, 1, 3);
						people[3] = dfs(N, N, 4);
						people[4] = SUM - (people[0] + people[1] + people[2] + people[3]);
						Arrays.sort(people);
						if(MIN > people[4] - people[0]) {
							MIN = people[4] - people[0];
						}
					}
				}
			}
		}
		
		bw.write(MIN + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int dfs(int x, int y, int z) {
		board[x][y] = -1;
		int sum = city[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((1 <= nx && nx <= N) && (1 <= ny && ny <= N) && board[nx][ny] == z) {
				sum += dfs(nx, ny, z);
			}
		}
		return sum;
	}
}
