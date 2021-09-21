package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//공유기 설치
public class BJ2110 {
	static int N, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		bw.write(solve() + "\n");
//		bw.write(solve(0, arr.length - 1, 2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve() {
		int left = 1;	//공유기 사이 거리의 최소값은 1
		int right = arr[arr.length - 1] - arr[0];	//공유기 사이 거리의 최대값은 (가장 마지막 좌표 - 가장 처음 좌표)
		int mid = 0;
		int result = 1;
		while(left <= right) {
			mid = (left + right) / 2;	//공유기 사이의 거리 중간값을 구한다.
			int count = 1;
			int start = arr[0];
			for(int i = 1; i < arr.length; i++) {	//모든 좌표를 순환하며 그 중간값으로 얼마나 공유기를 설치할 수 있는지 계산
				if(arr[i] - start >= mid) {
					count++;
					start = arr[i];
				}
			}
			if(count >= C) {	//공유기를 원하는 만큼 이상 설치 가능하면 공유기 사이 거리값을 올려본다.
				result = mid;
				left = mid + 1;
			}else{				//공유기를 원하는 만큼 설치를 못한다면 공유기 사이 거리값을 줄여본다.
				right = mid - 1;
			}
		}
		return result;
	}
    /*
     * 시간 초과
     * static int solve(int start, int end, int n) {
    	if(start == end) {
    		return 1000000001;
    	}
		if(n == C) {
			return arr[end] - arr[start];
		}
		int mid = (arr[start] + arr[end]) / 2;
		int midIndex = (start + end) / 2;
		if(arr[midIndex] > mid) {
			while(midIndex - 1 > start && (Math.abs(mid - arr[midIndex]) > Math.abs(mid - arr[midIndex - 1]))) {
				midIndex--;
			}
		}else if(arr[midIndex] < mid){
			while(midIndex + 1 < end && (Math.abs(mid - arr[midIndex]) > Math.abs(mid - arr[midIndex + 1]))) {
				midIndex++;
			}
		}
		return Math.min(solve(start, midIndex, n + 1), solve(midIndex, end, n + 1));
	}*/
}
