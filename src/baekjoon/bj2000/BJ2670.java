package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//연속부분최대곱
public class BJ2670 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];	//arr[i] = i까지의 연속부분최대곱
		for(int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		for(int i = 1; i < N; i++) {	//i가 arr[i - 1]와 연속곱이 되느냐 또는 i가 연속곱의 시작이 되느냐 중 최대값.
			arr[i] = Math.max(arr[i], arr[i - 1] * arr[i]);
		}
		
		double max = Double.MIN_VALUE;
		for(int i = 0 ; i < N; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		bw.write(String.format("%.3f\n", max));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
