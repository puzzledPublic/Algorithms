package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//합 구하기
public class BJ11441 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(br.readLine());
		
		int[] pSum = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {	//부분합
			pSum[i] = Integer.parseInt(st.nextToken()) + pSum[i - 1];
		}
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write((pSum[e] - pSum[s - 1]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
