package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen
public class BJ9663 {
	static int N, count;
	static boolean[] col, inc, dec;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new boolean[N + 1];
		inc = new boolean[N + N + 1];
		dec = new boolean[N + N + 1];
		solve(1);
		System.out.println(count);
	}
	static void solve(int n) {
		if(n > N) {
			count++;
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!col[i] && !inc[n + i] && !dec[N + (n - i) + 1]) {
				col[i] = inc[n + i] = dec[N + (n - i) + 1] = true;
				solve(n + 1);
				col[i] = inc[n + i] = dec[N + (n - i) + 1] = false;
			}
		}
	}
}
//	시간초과 방식
//public class BJ9663 {
//	static int N, count;
//	static int[][] arr;
//	static int[][] d = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		arr = new int[N][N];
//		solve(0);
//		System.out.println(count);
//	}
//	static void solve(int n) {
//		if(n == N) {
//			count++;
//			return;
//		}
//		for(int i = 0; i < N; i++) {
//			if(arr[n][i] == 0) {
//				check(n, i, 1);
//				solve(n + 1);
//				check(n, i, -1);
//			}
//		}
//	}
//	static void check(int n, int k, int mark) {
//		arr[n][k] += mark;
//		for(int i = 0; i < 5; i++) {
//			int a = n + d[i][0];
//			int b = k + d[i][1];
//			while(0 <= a && a < N && 0 <= b && b < N) {
//				arr[a][b] += mark;
//				a += d[i][0];
//				b += d[i][1];
//			}
//		}
//	}
//}
