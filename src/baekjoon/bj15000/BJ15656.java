package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (7)
public class BJ15656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] print = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		solve(arr, print, 0, M, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, int[] print, int n, int M, Writer w) throws IOException {
		if(n == M) {
			for(int i = 0; i < M - 1; i++) {
				w.write(print[i] + " ");
			}
			w.write(print[M - 1] + "\n");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			print[n] = arr[i];
			solve(arr, print, n + 1, M, w);
		}
	}
}
