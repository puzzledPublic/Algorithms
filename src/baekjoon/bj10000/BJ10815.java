package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드
public class BJ10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	//이분탐색을 위한 정렬
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			if(i != M - 1) {
				bw.write(solve(arr, Integer.parseInt(st.nextToken())) + " ");
			}else {
				bw.write(solve(arr, Integer.parseInt(st.nextToken())) + "");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int[] arr, int n) {	//이분탐색
		int left = 0, right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == n) {
				return 1;
			}else if(arr[mid] < n) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return 0;
	}
}
