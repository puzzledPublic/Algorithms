package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//오르막길
public class BJ2846 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0, start = 0, end = 0;	//max = 오르막 최대 크기, start, end = 오르막의 처음, 끝 포인터
		for(int i = 1; i < N + 1; i++) {
			if(arr[i - 1] >= arr[i]) {	//오름차순이 끝나는 경우 현재 오르막 크기를 비교 후 갱신.
				if(max < arr[end] - arr[start]) {
					max = arr[end] - arr[start];
				}
				start = end = i;	//포인터 새 위치로 초기화
			}else {	//오르막이 지속되면
				end = i;	//끝 포인터 증가.
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
