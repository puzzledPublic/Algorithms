package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//종이의 개수
public class BJ1780 {
	static int[] paper = new int[3];
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(N, 0, 0);
		for(int i = 0; i < 3; i++) {
			bw.write(paper[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int x, int y) {
		if(n == 1 || check(n, x, y)) {
			paper[arr[x][y] + 1]++;
			return;
		}else {
			solve(n / 3, x, y);
			solve(n / 3, x, y + (n / 3));
			solve(n / 3, x, y + (n / 3) * 2);
			solve(n / 3, x + (n / 3), y);
			solve(n / 3, x + (n / 3), y + (n / 3));
			solve(n / 3, x + (n / 3), y + (n / 3) * 2);
			solve(n / 3, x + (n / 3) * 2, y);
			solve(n / 3, x + (n / 3) * 2, y + (n / 3));
			solve(n / 3, x + (n / 3) * 2, y + (n / 3) * 2);
		}
	}
	static boolean check(int n, int x, int y) {
		int t = arr[x][y];
		for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(t != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
