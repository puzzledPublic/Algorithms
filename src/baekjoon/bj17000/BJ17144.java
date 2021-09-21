package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//미세먼지 안녕!
public class BJ17144 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[R][C];
		int[][] copyRoom = new int[R][C];
		int[][] cleaner = new int[2][2];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) {
					cleaner[1][0] = i;
					cleaner[1][1] = j;
				}
			}
		}
		
		cleaner[0][0] = cleaner[1][0] - 1;
		cleaner[0][1] = cleaner[1][1];
		
		for(int t = 0; t < T; t++) {
			//미세먼지 뿜뿜
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(room[i][j] >= 5) {
						int directCount = 0;
						for(int k = 0; k < d.length; k++) {
							int nx = i + d[k][0], ny = j + d[k][1];
							if((0 <= nx && nx < R) && (0 <= ny && ny < C) && room[nx][ny] != -1) {
								copyRoom[nx][ny] += room[i][j] / 5;
								directCount++;
							}
						}
						room[i][j] -= (room[i][j] / 5) * directCount;
					}
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					room[i][j] += copyRoom[i][j];
					copyRoom[i][j] = 0;
				}
			}

			//공기청정기 뿜뿜
			int temp = room[cleaner[0][0]][1], temp2;
			room[cleaner[0][0]][1] = 0;
			for(int j = 2; j < C; j++) {
				temp2 = room[cleaner[0][0]][j];
				room[cleaner[0][0]][j] = temp;
				temp = temp2;
			}
			for(int i = cleaner[0][0] - 1; i >= 0; i--) {
				temp2 = room[i][C - 1];
				room[i][C - 1] = temp;
				temp = temp2;
			}
			for(int j = C - 2; j >= 0; j--) {
				temp2 = room[0][j];
				room[0][j] = temp;
				temp = temp2;
			}
			for(int i = 1; i < cleaner[0][0]; i++) {
				temp2 = room[i][0];
				room[i][0] = temp;
				temp = temp2;
			}
			
			temp = room[cleaner[1][0]][1];
			room[cleaner[1][0]][1] = 0;
			for(int j = 2; j < C; j++) {
				temp2 = room[cleaner[1][0]][j];
				room[cleaner[1][0]][j] = temp;
				temp = temp2;
			}
			for(int i = cleaner[1][0] + 1; i < R; i++) {
				temp2 = room[i][C - 1];
				room[i][C - 1] = temp;
				temp = temp2;
			}
			for(int j = C - 2; j >= 0; j--) {
				temp2 = room[R - 1][j];
				room[R - 1][j] = temp;
				temp = temp2;
			}
			for(int i = R - 2; i > cleaner[1][0]; i--) {
				temp2 = room[i][0];
				room[i][0] = temp;
				temp = temp2;
			}
		}
		
		int count = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				count += room[i][j];
			}
		}
		
		bw.write((count + 2) + "\n"); 
		bw.flush();
		bw.close();
		br.close();
	}
}
