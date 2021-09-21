package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//여왕벌
public class BJ10836 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] grow = new int[2 * N - 1];	//왼쪽아래서부터 위 그리고 오른쪽 위까지 자라는 길이를 담는 배열.
		int[] sum = new int[2 * N - 1];		//스스로 자라는 애벌레의 총 크기.
		int[] col = new int[N - 1];	//영향을 받아 자라는 애벌레의 총 크기.
		Arrays.fill(sum, 1);
		Arrays.fill(col, 1);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			int index = 0;
			for(int j = 0; j < zero; j++) {
				grow[index] = 0;
				sum[index++] += 0;
			}
			for(int j = 0; j < one; j++) {
				grow[index] = 1;
				sum[index++] += 1;
			}
			for(int j = 0; j < two; j++) {
				grow[index] = 2;
				sum[index++] += 2;
			}
			for(int j = N; j < 2 * N - 1; j++) {	//영향을 받아 자라는 애벌레의 크기는 스스로 자라는 애벌레의 첫행에 영향을 받는다
				col[j - N] += grow[j];
			}
		}
		
		for(int i = N - 1; i < 2 * N - 1; i++) {
			bw.write(sum[i] + " ");
		}
		bw.write("\n");
		for(int i = N - 2; i >= 0; i--) {
			bw.write(sum[i] + " ");
			for(int j = 0; j < N - 1; j++) {
				bw.write(col[j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
