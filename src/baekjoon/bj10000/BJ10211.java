package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Maximum Subarray
public class BJ10211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1000;
			for(int i = 1; i <= N; i++) {
				arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
				max = Math.max(max,  arr[i]);
			}
			
			bw.write(max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
