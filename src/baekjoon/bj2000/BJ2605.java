package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//줄 세우기
public class BJ2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {	//초기 순서
			arr[i] = i + 1;
		}
		
		for(int i = 0; i < N; i++) {
			int time = Integer.parseInt(st.nextToken());	//현재 위치서 time칸 앞으로
			for(int j = i; j > i - time; j--) {				//거꾸로 time번 버블
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		
		for(int i = 0; i < N; i++) {	//순서 출력
			bw.write(arr[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
