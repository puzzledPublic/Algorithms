package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//숫자 정사각형
public class BJ1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		char[][] rect = new char[N][];
		
		for(int i = 0; i < N; i++) {
			rect[i] = br.readLine().toCharArray();
		}
		
		bw.write(solve(rect, N, M) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve(char[][] rect, int N, int M) {
		int line = (N < M ? N : M) - 1;	//직사각형에서 작은 변의 길이
		
		for(int k = line; k > 0; k--) {	//한변의 길이
			for(int i = 0; i < N - k; i++) {	//i, j => 정사각형의 왼쪽 위 꼭지점
				for(int j = 0; j < M - k; j++) {
					int num = rect[i][j];
					if(rect[i + k][j] == num && rect[i][j + k] == num && rect[i + k][j + k] == num) {	//네 꼭지점의 값이 같으면 최대 정사각형이된다. 바로리턴
						return (k + 1) * (k + 1);
					}
				}
			}
		}
		return 1;
	}
}
