package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//버블 소트
public class BJ1517 {
	static int[] arr, tmp;
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		tmp = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, N - 1);
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//merge sort
	static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	static void merge(int start, int mid, int end) {
		int a = start;
		int b = mid + 1;
		int k = 0;
		//start ~ mid, mid + 1 ~ end까지는 정렬된 상태이고 start ~ mid, mid + 1 ~ end를 정렬하는데 오른쪽 숫자(mid + 1 ~ end 사이 숫자)가 더 작은 경우 버블 정렬시 교환이 일어난다.
		while(a <= mid && b <= end) {
			if(arr[a] <= arr[b]) {
				tmp[k++] = arr[a++];
			}else {
				count += (mid + 1 - a);
				tmp[k++] = arr[b++];
			}
		}
		
		while(a <= mid) {
			tmp[k++] = arr[a++];
		}
		
		while(b <= mid) {
			tmp[k++] = arr[b++];
		}
		
		a = start;
		for(int i = 0; i < k; i++) {
			arr[a++] = tmp[i];
		}
	}
}
