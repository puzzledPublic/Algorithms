package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//크로스워드 만들기
public class BJ2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken(), B = st.nextToken();
		char[][] board = new char[B.length()][A.length()];	//크로스 워드 결과를 넣을 배열
		
		for(int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}
		
		int n = -1, m = -1;
		tal: for(int i = 0; i < A.length(); i++) {	//A와 B문자열에 공통된 문자중 A문자열에서 가장 앞에 있는 문자선택
			char ch = A.charAt(i);
			for(int j = 0; j < B.length(); j++) {
				if(ch == B.charAt(j)) {
					n = j;	//n = board에서 A문자열이 시작할 행 위치
					m = i;	//m = board에서 B문자열이 시작할 열 위치
					break tal;
				}
			}
		}
		
		for(int i = 0; i < B.length(); i++) {
			board[i][m] = B.charAt(i);
		}
		for(int i = 0; i < A.length(); i++) {
			board[n][i] = A.charAt(i);
		}
		
		//출력
		for(int i = 0; i < B.length(); i++) {
			for(int j = 0; j < A.length(); j++) {
				bw.write(board[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
