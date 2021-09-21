package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Puyo Puyo
public class BJ11559 {
	static boolean boom;
	static char[][] stage;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		stage = new char[12][];
		for(int i = 0; i < 12; i++) {
			stage[i] = br.readLine().toCharArray();
		}

		int result = 0;
		boom = true;	//현재 스테이지에서 터진적이 있는가
		while(boom) {
			boom = false;
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 6; j++) {
					if(stage[i][j] != '.') {
						char current = stage[i][j];	//현재 문자 저장.
						if(is4Above(i, j, stage[i][j], 'X') < 4) {	//연결된 문자가 4개 미만이면
							is4Above(i, j, 'X', current);	//현재 문자로 원상복구
						}else {
							boom = true;
							is4Above(i, j, 'X', '.');	//연결된 문자가 4개 이상이면 '.'으로 바꾼다.
						}
					}
				}
			}
			
			//문자들을 떨어뜨린다.
			for(int j = 0; j < 6; j++) {
				for(int i = 11; i >= 0; i--) {
					if(stage[i][j] != '.') {
						int t = i + 1;
						while(t < 12 && stage[t][j] == '.') {
							t++;
						}
						if(stage[t - 1][j] == '.') {
							stage[t - 1][j] = stage[i][j];
							stage[i][j] = '.';
						}
					}
				}
			}
			//현재 스테이지에서 터진적이 있다면 횟수 증가.
			if(boom) {
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int is4Above(int x, int y, char typeFrom, char typeTo) {	//해당 문자(typeFrom)을 typeTo로 바꾸며 상하좌우로 typeFrom이 연결된 갯수를 반환한다.
		stage[x][y] = typeTo;
		int result = 1;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < 12) && (0 <= ny && ny < 6) && stage[nx][ny] == typeFrom) {
				result += is4Above(nx, ny, typeFrom, typeTo);
			}
		}
		return result;
	}
}
