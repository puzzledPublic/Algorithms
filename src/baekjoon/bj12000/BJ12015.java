package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열 2
public class BJ12015 {
	static int[] arr;
	static int[] tmp;	//증가 수열을 유지할 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tmp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		for(int i = 1; i <= N; i++) {
			if(tmp[index] < arr[i]) {	//현재 숫자가 증가 수열 배열의 마지막 수보다 크면 증가 수열 맨 뒤에 추가.
				index++;
				tmp[index] = arr[i];
			}else {	//크지 않으면 증가 수열에서 arr[i]의 lower_bound를 찾아 그 위치에 대체
				int t = binarySearch(index, arr[i]);
				tmp[t] = arr[i];
			}
		}
		
		bw.write(index + "\n");	//증가 수열의 크기
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int binarySearch(int end, int n) {
		int start = 0;
		while(start < end) {
			int mid = (start + end) / 2;
			if(tmp[mid] < n) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return start;
	}
}
