package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//꼬인 전깃줄
public class BJ1365 {
	static int[] arr;
	static int[] lis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		arr = new int[N];
		lis = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lastIndex= 0;
		for(int i = 0; i < N; i++) {
			if(lastIndex == 0 || lis[lastIndex] < arr[i]) {	//처음, 또는 lis 마지막 원소보다 arr[i]가 크면 lis배열 뒤에 붙인다.
				lastIndex++;
				lis[lastIndex] = arr[i];
			}else {
				int index = binarySearch(lastIndex, arr[i]);
				lis[index] = arr[i];
			}
		}
		
		bw.write((N - lastIndex) + "\n"); 
		
		bw.flush();
		bw.close();
		br.close();
	}
	//lis[0~lastIndex]에서 value의 lower bound index를 찾는다.
	static int binarySearch(int lastIndex, int value) {
		int start = 0;
		int end = lastIndex;
		while(start < end) {
			int mid = (start + end) / 2;
			if(lis[mid] < value) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		
		return start;
	}
}
