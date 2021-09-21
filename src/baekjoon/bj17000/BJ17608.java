package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//막대기
public class BJ17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] pipe = new int[N];
		for(int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		int max = Integer.MIN_VALUE;
		for(int i = N - 1; i >= 0; i--) {
			if(max < pipe[i]) {
				max = pipe[i];
				count++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
