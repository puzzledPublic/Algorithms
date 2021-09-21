package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//두 개의 숫자열
public class SWEA1959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			int result = Integer.MIN_VALUE;
			if(N < M) {
				for(int j = 0; j < M - N + 1; j++) {
					int comp = 0;
					for(int k = 0; k < N; k++) {
						comp += (A[k] * B[k + j]);
					}
					if(result < comp) {
						result = comp;
					}
				}
			}else {
				for(int j = 0; j < N - M + 1; j++) {
					int comp = 0;
					for(int k = 0; k < M; k++) {
						comp += (B[k] * A[k + j]);
					}
					if(result < comp) {
						result = comp;
					}
				}
			}
			bw.write("#" + i + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
