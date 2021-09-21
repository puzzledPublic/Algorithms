package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//체스판 다시 칠하기
public class BJ1018 {
	static char[][] compare = {
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
		{'B','W','B','W','B','W','B','W'},
		{'W','B','W','B','W','B','W','B'},
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int min = 2501;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				int change = 0;
				for(int k = 0; k < 8; k++) {	//잘라낸 보드를 화이트 보드로 만들때
					for(int u = 0; u < 8; u++) {
						if(compare[k][u] != board[i + k][j + u]) {
							change++;
						}
					}
				}
				if(min > change) {
					min = change;
				}
				change = 0;
				for(int k = 1; k < 9; k++) {	//잘라낸 보드를 블랙 보드로 만들때
					for(int u = 0; u < 8; u++) {
						if(compare[k][u] != board[i + k - 1][j + u]) {
							change++;
						}
					}
				}
				if(min > change) {
					min = change;
				}
			}
		}
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
