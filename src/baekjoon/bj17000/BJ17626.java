package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Four Squares
public class BJ17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];	//N이 제곱수의 합으로 표현될 때 최소 제곱수의 개수
		Arrays.fill(arr, 987654321);
		arr[0] = 0;
		arr[1] = 1;
		
		//arr[N] = Math.min(arr[N - 1^2] + 1, arr[N - 2^2] + 1, arr[N - 3^3] + 1 ... arr[N - i^i] + 1) (i * i <= N)
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j * j <= i; j++) {
				arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
			}
		}
		
		bw.write(arr[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
