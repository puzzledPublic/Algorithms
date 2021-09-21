package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//최대곱
public class BJ1500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		Arrays.fill(arr, S / K);
		long mul = 1;
		for(int i = 0; i < K; i++) {
			if(i < S % K) {
				mul *= (arr[i] + 1);
			}else {
				mul *= arr[i];
			}
		}
		
		bw.write(mul + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
