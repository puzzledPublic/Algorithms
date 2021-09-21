package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//우유가 넘어지면?
public class BJ17363 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] origin = new char[N][];
		char[][] trans = new char[M][N];
		
		for(int i = 0; i < N; i++) {
			origin[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				char ch = origin[i][j];	//뒤집었을때 변하는 문자
				if(ch == '-') {
					ch = '|';
				}else if(ch == '|') {
					ch = '-';
				}else if(ch == '/') {
					ch = '\\';
				}else if(ch == '\\') {
					ch = '/';
				}else if(ch == '^') {
					ch = '<';
				}else if(ch == '<') {
					ch = 'v';
				}else if(ch == 'v') {
					ch = '>';
				}else if(ch == '>') {
					ch = '^';
				}
				trans[M - j - 1][i] = ch;	//행렬을 왼쪽으로 뒤집기
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(trans[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
