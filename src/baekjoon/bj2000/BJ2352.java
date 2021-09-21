package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//반도체 설계 (NlogN 복잡도의 LIS 알고리즘이 필요)
public class BJ2352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int[] temp = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = 1;
		for(int i = 0; i < N; i++) {
			if(temp[len - 1] < arr[i]) {	//temp의 마지막 숫자보다 더 큰 숫자라면
				temp[len++] = arr[i];	//그대로 뒤에 이어 붙인다.
			}else {	//temp의 마지막 숫자보다 더 작은 숫자라면
				int index = binarySearch(temp, arr[i], len);
				temp[index] = arr[i];	//해당 인덱스의 위치에 현재 숫자 삽입.
			}
		}
		
		bw.write((len - 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int binarySearch(int[] temp, int num, int end) {	//이분탐색, temp 배열에서 num보다 더 큰 숫자 중 최소인 숫자의 인덱스를 찾는다. upper_bound
		int start = 1;
		while(start < end) {
			int mid = (start + end) / 2;
			if(temp[mid] > num) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
}
