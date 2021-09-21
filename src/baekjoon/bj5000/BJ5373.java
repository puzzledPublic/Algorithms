package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//큐빙
public class BJ5373 {
	static char[][][] cube = new char[6][3][3];
	static char[][] temp = new char[3][3];	//면 회전시 사용할 캐쉬
	static char[] temp2 = new char[3];		//면과 인접한 열을 회전시 사용할 캐쉬
	static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < cube.length; j++) {	//큐브 초기화
				for(int k = 0; k < 3; k++) {
					for(int u = 0; u < 3; u++) {
						cube[j][k][u] = color[j];
					}
				}
			}
			
			for(int j = 0; j < N; j++) {
				String s = st.nextToken();
				char position = s.charAt(0), direction = s.charAt(1);
				switch(position) {
				case 'U':
					upRotate(direction);
					break;
				case 'D':
					downRotate(direction);
					break;
				case 'F':
					forwardRotate(direction);
					break;
				case 'B':
					backRotate(direction);
					break;
				case 'L':
					leftRotate(direction);
					break;
				case 'R':
					rightRotate(direction);
					break;
				}
			}
			
			for(int j = 0; j < 3; j++) {
				for(int k =0; k < 3; k++) {
					bw.write(cube[0][j][k]);
				}
				bw.write('\n');
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	//해당 면을 회전
	static void rotate(int n, char d) {
		if(d == '+') {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					temp[j][2 - i] = cube[n][i][j];
				}
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					cube[n][i][j] = temp[i][j];
				}
			}
		}else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					temp[2 - j][i] = cube[n][i][j];
				}
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					cube[n][i][j] = temp[i][j];
				}
			}
		}
	}
	//up 면과 인접한 열을 회전
	static void upRotate(char d) {
		if(d == '+') {
			rotate(0, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[4][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][0][i] = cube[2][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][0][i] = cube[5][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][0][i] = cube[3][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][0][i] = temp2[i];
			}
		}else {
			rotate(0, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[5][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][0][i] = cube[2][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][0][i] = cube[4][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][0][i] = cube[3][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][0][i] = temp2[i];
			}
		}
	}
	//down 면과 인접한 열을 회전
	static void downRotate(char d) {
		if(d =='+') {
			rotate(1, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[5][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][2][i] = cube[2][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][2][i] = cube[4][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2][i] = cube[3][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][2][i] = temp2[i];
			}
		}else {
			rotate(1, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[4][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2][i] = cube[2][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][2][i] = cube[5][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][2][i] = cube[3][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][2][i] = temp2[i];
			}
		}
	}
	//forward 면과 인접한 열을 회전
	static void forwardRotate(char d) {
		if(d =='+') {
			rotate(2, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[5][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][i][0] = cube[0][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][2][2 - i] = cube[4][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2 - i][2] = cube[1][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][2][i] = temp2[i];
			}
		}else {
			rotate(2, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[4][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2 - i][2] = cube[0][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][2][i] = cube[5][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][i][0] = cube[1][2][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][2][2 - i] = temp2[i];
			}
		}
	}
	////back 면과 인접한 열을 회전
	static void backRotate(char d) {
		if(d =='+') {
			rotate(3, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[4][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2 - i][0] = cube[0][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][0][i] = cube[5][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][i][2] = cube[1][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][0][2 - i] = temp2[i];
			}
		}else {
			rotate(3, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[5][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[5][i][2] = cube[0][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][0][2 - i] = cube[4][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[4][2 - i][0] = cube[1][0][i];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][0][i] = temp2[i];
			}
		}
	}
	//left 면과 인접한 열을 회전
	static void leftRotate(char d) {
		if(d =='+') {
			rotate(4, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[2][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][i][0] = cube[0][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][2 - i][0] = cube[3][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][i][2] = cube[1][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][2 - i][2] = temp2[i];
			}
		}else {
			rotate(4, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[3][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][2 - i][2] = cube[0][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][i][0] = cube[2][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][2 - i][0] = cube[1][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][i][2] = temp2[i];
			}
		}
	}
	//right 면과 인접한 열을 회전
	static void rightRotate(char d) {
		if(d =='+') {
			rotate(5, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[3][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][2 - i][0] = cube[0][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][i][2] = cube[2][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][2 - i][2] = cube[1][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][i][0] = temp2[i];
			}
		}else {
			rotate(5, d);
			for(int i = 0; i < 3; i++) {
				temp2[i] = cube[2][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[2][i][2] = cube[0][i][2];
			}
			for(int i = 0; i < 3; i++) {
				cube[0][2 - i][2] = cube[3][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[3][i][0] = cube[1][i][0];
			}
			for(int i = 0; i < 3; i++) {
				cube[1][2 - i][0] = temp2[i];
			}
		}
	}
}
