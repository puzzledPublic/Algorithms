package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//점화식
public class BJ13699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		arr[0] = 1;
		for(int i = 1; i < N + 1; i++) {
			for(int j = 0; j < i; j++) {
				arr[i] += arr[j] * arr[i - j - 1];
			}
		}
		
		bw.write(arr[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
