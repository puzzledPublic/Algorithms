package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//흩날리는 시험지 속에서 내 평점이 느껴진거야
public class BJ17951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] score = new int[N];
		
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N * 20;
		
		while(start + 1 < end) {	//이분 탐색, 그룹 지었을때 각각의 문제를 맞춘 갯수들의 합 중 최소값을 정할때 그룹을 K개 이상으로 만들 수 있는가?
			int mid = (start + end) / 2;
			int sum = 0;
			int group = 0;
			for(int i = 0; i < N; i++) {
				sum += score[i];
				if(sum >= mid) {
					sum = 0;
					group++;
				}
				if(i == N - 1 && sum >= mid) {	//맨 마지막 그룹이 조건을 만족하는지 체크
					group++;
				}
			}
			
			if(group >= K) {	//그룹이 K개 이상이면 최소 점수를 높여본다.
				start = mid;
			}else {				//그룹이 K개 이하이면 최소 점수를 낮춰본다.
				end = mid;
			}
			
		}
		
		bw.write(start + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
