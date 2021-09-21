package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 정렬하기 2 (병합정렬)
public class BJ2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(arr, 0, N - 1);
		for(int i = 0; i < N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int arr[], int s, int e) {
		if(s < e) {
			int mid = (s + e) / 2;
			solve(arr, s, mid);
			solve(arr, mid + 1, e);
			merge(arr, s, mid, e);
		}
	}
	static void merge(int[] arr, int s, int mid, int e) {
		int i, j, k;
		i = s;
		j = mid + 1;
		k = 0;
		int[] temp = new int[e - s + 1];
		while(i <= mid && j <= e) {
			if(arr[i] > arr[j]) {
				temp[k] = arr[j];
				j++;
			}else {
				temp[k] = arr[i];
				i++;
			}
			k++;
		}
		if(i > mid) {
			for(int m = j; m <= e; m++) {
				temp[k++] = arr[m];
			}
		}else {
			for(int m = i; m <= mid; m++) {
				temp[k++] = arr[m];
			}
		}
		k = 0;
		for(int m = s; m <= e; m++) {
			arr[m] = temp[k++];
		}
	}
}
