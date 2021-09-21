package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//행렬 곱셈 (3중 for문으로 풀면 O(n^3), 슈트라센 알고리즘(분할정복)으로 풀면 O(n^2.807), 코퍼스미스-위노그라드 알고리즘(O(n^2.376)), 월리엄스(O(n^2.3727)))
public class BJ2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][][] Mat = new int[2][][];
		int n, m;
		
		StringTokenizer st;
		for(int k = 0; k < 2; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			Mat[k] = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < m; j++) {
					Mat[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		solve(Mat, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int[][][] mat, Writer w) throws IOException {
		int[][] result = new int[mat[0].length][mat[1][0].length];
		for(int i = 0; i < mat[0].length; i++) {
			for(int j = 0; j < mat[1][0].length; j++) {
				for(int k = 0; k < mat[0][0].length; k++) {
					result[i][j] += (mat[0][i][k] * mat[1][k][j]);
				}
			}
		}
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				w.write(result[i][j] + " ");
			}
			w.write("\n");
		}
	}
}
