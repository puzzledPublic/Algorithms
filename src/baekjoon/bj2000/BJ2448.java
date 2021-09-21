package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//별찍기 11
public class BJ2448 {
	static char[][] map = new char[3072][6144];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		solve(N, 0, N - 1);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2 - 1; j++) {
				bw.write(map[i][j] == '*' ? '*' : ' ');
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int x, int y) {
		if(n == 3) {
			map[x][y] = '*';
			map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
			map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
			return;
		}
		solve(n / 2, x, y);
		solve(n / 2, x + (n / 2), y - (n / 2));
		solve(n / 2, x + (n / 2), y + (n / 2));
	}
}
