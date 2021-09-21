package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//부울행렬의 부울곱
public class BJ14492 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] A = new char[N][N];
		char[][] B = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = st.nextToken().charAt(0);
			}
		}
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				B[i][j] = st.nextToken().charAt(0);
			}
		}
		
		//O(N^3) 행렬 곱
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(A[i][k] == '1' && B[k][j] == '1') {	//(a1&b1) | (a2&b2)...이므로 이들 중 하나만 true여도 1이된다.
						count++;
						break;	//더 해볼 필요 없이 다음으로 넘어감
					}
				}
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
