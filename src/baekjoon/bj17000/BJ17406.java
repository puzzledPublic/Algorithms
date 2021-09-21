package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//배열 돌리기4
public class BJ17406 {
	static int[][] matrix;
	static int[][] rotateInfo;
	static boolean[] visited;
	static int N, M, K, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N + 1][M + 1];
		rotateInfo = new int[K][3];
		visited = new boolean[K];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				rotateInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0);
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int k) {
		if(k == K) {
			int minRowSum = Integer.MAX_VALUE;	//모두 돌렸을때 배열의 최소값을 구한다.
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= M; j++) {
					sum += matrix[i][j];
				}
				if(minRowSum > sum) {
					minRowSum = sum;
				}
			}
			if(min > minRowSum) {
				min = minRowSum;
			}
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				rotateMatrix(i, true);	//시계방향으로 회전
				solve(k + 1);
				rotateMatrix(i, false);	//백트래킹. 반시계방향으로 회전
				visited[i] = false;
			}
		}
	}
	
	static void rotateMatrix(int k, boolean clock) {
		int r = rotateInfo[k][0];
		int c = rotateInfo[k][1];
		int s = rotateInfo[k][2];
		r -= s;
		c -= s;
		
		if(clock) {
			while(s > 0) {
				int prev = matrix[r][c];
				for(int i = c + 1; i < c + s * 2 + 1; i++) {
					int tmp = prev;
					prev = matrix[r][i];
					matrix[r][i] = tmp;
				}
				for(int i = r + 1; i < r + s * 2; i++) {
					int tmp = prev;
					prev = matrix[i][c + s * 2];
					matrix[i][c + s * 2] = tmp;
				}
				for(int i = c + s * 2; i >= c; i--) {
					int tmp = prev;
					prev = matrix[r + s * 2][i];
					matrix[r + s * 2][i] = tmp;
				}
				for(int i = r + s * 2 - 1; i >= r; i--) {
					int tmp = prev;
					prev = matrix[i][c];
					matrix[i][c] = tmp;
				}
				r++;
				c++;
				s--;
			}
		}else {
			while(s > 0) {
				int prev = matrix[r][c];
				for(int i = r + 1; i < r + s * 2 + 1; i++) {
					int tmp = prev;
					prev = matrix[i][c];
					matrix[i][c] = tmp;
				}
				for(int i = c + 1; i < c + s * 2; i++) {
					int tmp = prev;
					prev = matrix[r + s * 2][i];
					matrix[r + s * 2][i] = tmp;
				}
				for(int i = r + s * 2; i >= r; i--) {
					int tmp = prev;
					prev = matrix[i][c + s * 2];
					matrix[i][c + s * 2] = tmp;
				}
				for(int i = c + s * 2 - 1; i >= c; i--) {
					int tmp = prev;
					prev = matrix[r][i];
					matrix[r][i] = tmp;
				}
				r++;
				c++;
				s--;
			}
		}
	}
}
