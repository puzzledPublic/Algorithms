package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//벚꽃이 정보섬에 피어난 이유
public class BJ17127 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 0; i < N - 3; i++) {	//4구간으로 나눈다.
			for(int j = i + 1; j < N - 2; j++) {
				for(int k = j + 1; k < N - 1; k++) {
					int sum = 0, mul = 1;
					for(int h = 0; h <= i; h++) {
						mul *= arr[h];
					}
					sum += mul;
					mul = 1;
					for(int h = i + 1; h <= j; h++) {
						mul *= arr[h];
					}
					sum += mul;
					mul = 1;
					for(int h = j + 1; h <= k; h++) {
						mul *= arr[h];
					}
					sum += mul;
					mul = 1;
					for(int h = k + 1; h < N; h++) {
						mul *= arr[h];
					}
					sum += mul;
					if(max < sum) {
						max = sum;
					}
				}
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
