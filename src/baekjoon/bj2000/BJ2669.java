package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//직사각형 네개의 합집합의 면적 구하기
public class BJ2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[][] board = new boolean[101][101];
		
		//주어진 구역 크기가 작으므로 배열에 해당 구역을 칠한 후 칠해진 구역 수를 센다.
		for(int k = 0; k < 4; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					board[i][j] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(board[i][j]) {
					count++;
				}
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
