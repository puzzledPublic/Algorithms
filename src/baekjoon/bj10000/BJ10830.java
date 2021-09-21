package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//행렬 제곱
public class BJ10830 {
	static int N;
	static long B;
	static int[][] E;	//Identity Matrix
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		int[][] mat = new int[N][N];
		E = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(i == j) {
					E[i][j] = 1;
				}
			}
		}
		
		int[][] result = powMat(mat, B);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[][] powMat(int[][] mat, long b) {	//행렬 제곱
		if(b == 0) {
			return E;
		}
		
		if(b % 2 == 0) {	//b가 짝수면 pow(b / 2) * pow(b / 2)
			int[][] tmp = powMat(mat, b / 2);
			return multiplyMatrix(tmp, tmp);
		}else {	//b가 홀수면 mat * pow(b - 1)
			return multiplyMatrix(mat, powMat(mat, b - 1));
		}
	}
	
	static int[][] multiplyMatrix(int[][] left, int[][] right) {	//행렬 곱
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					result[i][j] = (result[i][j] + ((left[i][k] * right[k][j]) % 1000)) % 1000;
				}
			}
		}
		return result;
	}
}
