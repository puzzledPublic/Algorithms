package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나의 인생에는 수학과 함께
public class BJ17265 {
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static char[][] map;
	static int[][] d = {{0, 1}, {1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		solve(0, 0, ' ', map[0][0] - '0');
		
		bw.write(max + " " + min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int x, int y, char op, int value) {
		
		if(x == N - 1 && y == N - 1) {
			if(min > value) {
				min = value;
			}
			if(max < value) {
				max = value;
			}
			return;
		}
		
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
				if(0 <= map[nx][ny] - '0' && map[nx][ny] - '0' <= 5) {
					solve(nx, ny, ' ', operate(op, value , map[nx][ny] - '0'));
				}else {
					solve(nx, ny, map[nx][ny], value);
				}
			}
		}
	}
	static int operate(char op, int a, int b) {
		int r = 0;
		switch(op) {
		case '+':
			r =  a + b;
			break;
		case '-':
			r = a - b;
			break;
		case '*':
			r = a * b;
			break;
		}
		return r;
	}
}
