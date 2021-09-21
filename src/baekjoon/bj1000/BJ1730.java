package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//판화
public class BJ1730 {
	static char[][] board;
	static int N;
	static int x, y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		board = new char[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(board[i], '.');
		}
		
		for(int i = 0; i < str.length(); i++) {
			draw(str.charAt(i));
		}
		
		for(int i = 0; i < N; i++) {	//출력
			for(int j = 0; j < N; j++) {
				bw.write(board[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//현재 위치(x, y)와 다음 위치(nx, ny)를 명령에 맞게 바꾼다.
	static void draw(char dir) {
		int nx = x, ny = y;	//nx, ny 다음 위치
		switch(dir) {
		case 'U':	//위
			nx--;
			break;
		case 'D':	//아래
			nx++;
			break;
		case 'L':	//왼쪽
			ny--;
			break;
		case 'R':	//오른쪽
			ny++;
			break;
		}
		
		if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {	//해당 범위 내이고
			if(dir == 'U' || dir == 'D') {	//위, 아래
				if(board[x][y] == '-') {	// '-' -> '+'
					board[x][y] = '+';
				}else if(board[x][y] == '.'){	//'.' -> '|'
					board[x][y] = '|';
				}
				if(board[nx][ny] == '-') {
					board[nx][ny] = '+';
				}else if(board[nx][ny] == '.'){
					board[nx][ny] = '|';
				}
			}else if(dir == 'L' || dir == 'R') {	//왼쪽, 오른쪽
				if(board[x][y] == '|') {	// '|' -> '+'
					board[x][y] = '+';
				}else if(board[x][y] == '.'){	//'.' -> '-'
					board[x][y] = '-'; 
				}
				if(board[nx][ny] == '|') {
					board[nx][ny] = '+';
				}else if(board[nx][ny] == '.'){
					board[nx][ny] = '-';
				}
			}
			
			x = nx;	//다음 위치로
			y = ny;
		}
	}
}
