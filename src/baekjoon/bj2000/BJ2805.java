package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나무 자르기
public class BJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), max = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {	//최대 나무 길이
				max = arr[i];
			}
		}
		
		bw.write(solve(arr, M, max) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int[] arr, int M, int max) {
		long start = 0, end = max, mid = 0, r = 0;
		while(start <= end) {	//이진탐색
			r = 0;
			mid = (start + end) / 2;
			for(int i = 0; i < arr.length; i++) {	//mid = 현재 절단기의 설정 높이, mid로 나무들을 잘랐을때 얻을 수 있는 나무 길이 계산.
				if(arr[i] > mid) {
					r += arr[i] - mid;
				}
			}
			
			if(M == r) {	//원하는 길이가 맞으면 바로 리턴
				break;
			}else if(M > r) {	//원하는 길이보다 짧으면 절단이 높이를 낮춘다.
				end = mid - 1;
			}else {				//원하는 길이보다 더 길면 절단기 높이를 높인다.
				start = mid + 1;
			}
		}
		if(r < M) {		//이진탐색이 끝났는데 얻는 나무 길이가 짧은 경우 절단기 높이를 1 줄인다.
			mid--;
		}
		return mid;
	}
}
