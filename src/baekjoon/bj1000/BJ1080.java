package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//행렬
//가장 좌측상단 요소를 뒤집는 건 그 요소를 기준으로 3x3행렬을 뒤집는 수 밖에 없다.
//그러므로 좌 -> 우, 상 -> 하로 탐색하며 원하는 요소와 다른 경우 그 요소를 기준으로 3x3행렬을 뒤집어 나간다.
public class BJ1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] matrixFrom = new char[N][];
		char[][] matrixTo = new char[N][];
		for(int i = 0; i < N; i++) {
			matrixFrom[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < N; i++) {
			matrixTo[i] = br.readLine().toCharArray();
		}
		
		int count = 0;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 2; j++) {
				if(matrixFrom[i][j] != matrixTo[i][j]) {
					count++;
					for(int k = i; k < i + 3; k++) {
						for(int u = j; u < j + 3; u++) {
							if(matrixFrom[k][u] == '0') {
								matrixFrom[k][u] = '1';
							}else {
								matrixFrom[k][u] = '0';
							}
						}
					}
				}
			}
		}
		
		boolean canChange = true;
		tal: for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(matrixFrom[i][j] != matrixTo[i][j]) {
					canChange = false;
					break tal;
				}
			}
		}
		
		bw.write((canChange ? count : -1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
