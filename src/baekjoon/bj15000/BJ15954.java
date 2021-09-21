package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//인형들
public class BJ15954 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		double min = 98764321;
		for(int i = K; i <= N; i++) {	// K번 이상 연속하는 인형의 범위에서 표준편차를 계산
			for(int j = 0; j <= N - i; j++) {
				min = Math.min(min, getStandardDeviation(j, j + i, i));
			}
		}
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static double getStandardDeviation(int start, int end, int n) {
		double avg = 0;
		for(int i = start; i < end; i++) {
			avg += arr[i];
		}
		avg /= n;
		double o = 0;
		for(int i = start; i < end; i++) {
			o += (arr[i] - avg) * (arr[i] - avg);
		}
		return Math.sqrt(o/n);
	}	
}
