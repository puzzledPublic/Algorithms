package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//게임을 만든 동준이
public class BJ2847 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int total = 0;
		for(int i = N - 2; i >= 0; i--) {	//역순으로 탐색.
			if(arr[i + 1] <= arr[i]) {	//바로 위 스테이지 점수보다 현재 스테이지 점수가 높으면 현재 스테이지 점수를 (바로 위 스테이지 점수 - 1)로 점수 조정.
				total += (arr[i] - arr[i + 1] + 1);	//점수 조정 크기.
				arr[i] = arr[i + 1] - 1;
			}
		}
		
		bw.write(total + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
