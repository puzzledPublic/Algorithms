package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//K번째 수 //quick select(quick정렬 기반)으로 푸는 문제
public class BJ11004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//solve(arr, 0, n - 1);
//		bw.write(arr[k - 1] + "\n");
		bw.write(solve2(arr, 0, n - 1, k - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//quick select
	static int solve2(int[] arr, int left, int right, int k) {
		int nth = partition(arr, left, right);	//피봇을 기준으로 쪼갠후 중간 위치를 돌려 받는다.
		if(nth == k) {	//우리가 원하는 위치면 리턴
			return arr[nth];
		}else if(nth > k) {	//원하는 위치보다 높으면 왼쪽편에 있다.
			return solve2(arr, left, nth - 1, k);
		}else {				//원하는 위치보다 낮으면 오른쪽편에 있다.
			return solve2(arr, nth + 1, right, k);
		}
	}
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left + 1, j = right;
		while(i < j) {
			while(i <= right && arr[i] <= pivot) {
				i++;
			}
			while(j >= (left + 1) && arr[j] >= pivot) {
				j--;
			}
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;
		return j;
	}
	
	//병합정렬. (가까스로 성공)
//	static void solve(int[] arr, int start, int end) {
//		if(start < end) {
//			int mid = (start + end) / 2;
//			solve(arr, start, mid);
//			solve(arr, mid + 1, end);
//			merge(arr, start, mid, end);
//		}
//	}
//	
//	static void merge(int[] arr, int start, int mid, int end) {
//		int[] temp = new int[end - start + 1];
//		int a = start;
//		int b = mid + 1;
//		int i = 0;
//		while(a <= mid && b <= end) {
//			if(arr[a] < arr[b]) {
//				temp[i++] = arr[a++];
//			}else {
//				temp[i++] = arr[b++];
//			}
//		}
//		if(a > mid) {
//			while(b <= end) {
//				temp[i++] = arr[b++];
//			}
//		}else {
//			while(a <= mid) {
//				temp[i++] = arr[a++];
//			}
//		}
//		for(int k = 0; k < temp.length; k++) {
//			arr[start++] = temp[k];
//		}
//	}
}
