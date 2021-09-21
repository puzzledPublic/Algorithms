package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나랏말싸미 America와 different~
public class BJ17181 {
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] table;
	static int[][][] dp;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		dp = new int[N][M][4];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(),  " ");
			for(int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				for(int k = 1; k < 4; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		if((table[0][0] <= 13)) {
			solve(0, 0, 0, 1);
		}
		
		result = Math.min(dp[N - 1][M - 1][2], dp[N - 1][M - 1][3]);
		bw.write((result == Integer.MAX_VALUE ? "BAD" : result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int x, int y, int len, int f) {
		if (dp[x][y][f] <= len) {
			return;
		}
		dp[x][y][f] = len;
		
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
				if(f == 3 && (table[nx][ny] <= 13)) {	//현재 모음이고 다음 위치가 자음인 경우
					solve(nx, ny, len, 1);	//초성으로 만드는 경우
					solve(nx, ny, len, 2);	//종성으로 만드는 경우
				}else if(f == 2 && (table[nx][ny] <= 13)) {	//현재 자음(종성)이고 다음 위치가 자음인 경우
					solve(nx, ny, len, 1);	//초성으로 만든다.
				}else if(f == 1 && (14 <= table[nx][ny])){	//현재 자음(초성)이고 다음 위치가 모음인 경우
					solve(nx, ny, len + 1, 3);	//글자 하나가 만들어진다.
				}
			}
		}
	}
}
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class BJ17181 {
//	static int N, M, result = Integer.MAX_VALUE;
//	static int[][] table;
//	static boolean[][] chk;
//	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		table = new int[N][M];
//		chk = new boolean[N][M];
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(),  " ");
//			for(int j = 0; j < M; j++) {
//				table[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		chk[0][0] = true;
//        if((table[0][0] <= 13)) {
//			solve(0, 0, 0, '1');
//		}
//		
//		bw.write((result == Integer.MAX_VALUE ? "BAD" : result) + "\n");
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	
//	static void solve(int x, int y, int len, char f) {
//		if(result <= len) {
//			return;
//		}
//		if(x == N - 1 && y == M - 1) {
//			if(f != '1' && result > len) {
//				result = len;
//			}
//			return;
//		}
//		for(int i = 0; i < d.length; i++) {
//			int nx = x + d[i][0], ny = y + d[i][1];
//			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && !chk[nx][ny]) {
//				chk[nx][ny] = true;
//				if(f == '3' && (table[nx][ny] <= 13)) {
//					solve(nx, ny, len, '1');
//					solve(nx, ny, len, '2');
//				}else if(f == '2' && (table[nx][ny] <= 13)) {
//					solve(nx, ny, len, '1');
//				}else if(f == '1' && 14 <= table[nx][ny]){
//					solve(nx, ny, len + 1, '3');
//				}
//				chk[nx][ny] = false;
//			}
//		}
//	}
//}