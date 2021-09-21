package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//구간 합 구하기4
public class BJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(),  " ");
		arr[1] = Integer.parseInt(st.nextToken());
		//부분합을 구한다.
		for(int i = 2; i < N + 1; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		//구간합을 구한다. arr[a~b] (a < b) = arr[b] - arr[a - 1]
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if(a < b) {				
				bw.write((arr[b] - arr[a - 1]) + "\n");
			}else{
				bw.write((arr[a] - arr[b - 1]) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
