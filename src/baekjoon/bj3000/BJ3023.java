package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//마술사 이민혁
public class BJ3023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] card = new char[R * 2][C * 2];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				card[i][j] = str.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				//카드의 좌하단, 우상단, 우하단을 각각 채운다.
				card[R * 2 - i - 1][j] = card[i][C * 2 - j - 1] = card[R * 2 - i - 1][C * 2 - j - 1] = card[i][j];
			}
		}
		
		card[x][y] = (card[x][y] == '#' ? '.' : '#');	//에러 넣기
		
		for(int i = 0; i < R * 2; i++) {	//출력
			for(int j = 0; j < C * 2; j++) {
				bw.write(card[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
