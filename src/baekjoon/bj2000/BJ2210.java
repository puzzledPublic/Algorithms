package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//숫자판 점프
public class BJ2210 {
	static char[][] board = new char[5][5];
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static Set<String> set = new HashSet<>();
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				solve(0, i, j, "");
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int x, int y, String str) {
		if(n == 6) {
			if(set.contains(str)) return;
			set.add(str);
			count++;
			return;
		}
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < 5) && (0 <= ny && ny < 5)) {
				solve(n + 1, nx, ny, str + board[x][y]);
			}
		}
	}
}
