package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//배열 합치기
public class BJ11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N], arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(arr1, arr2, bw);

		bw.flush();
		bw.close();
		br.close();
	}
	//합병정렬에서 합치는것처럼 하면된다.
	static void solve(int[] arr1, int[] arr2, Writer w) throws IOException {
		int arr1P = 0, arr2P = 0;	//배열1 포인터, 배열2 포인터
		while(arr1P < arr1.length && arr2P < arr2.length) {
			if(arr1[arr1P] > arr2[arr2P]) {
				w.write(arr2[arr2P] + " ");
				arr2P++;
			}else {
				w.write(arr1[arr1P] + " ");
				arr1P++;
			}
		}
		if(arr1P == arr1.length) {
			while(arr2P < arr2.length) {
				w.write(arr2[arr2P++] + " ");
			}
		}
		if(arr2P == arr2.length) {
			while(arr1P < arr1.length) {
				w.write(arr1[arr1P++] + " ");
			}
		}
	}
}
