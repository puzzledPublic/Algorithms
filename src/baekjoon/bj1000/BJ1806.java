package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//부분합
public class BJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int p1 = 0, p2 = 0, result = Integer.MAX_VALUE;	//투포인터
		
		int sum = 0;
		while(p2 < arr.length) {
			while(p2 < arr.length && sum < S) {	//합이 S가 넘을때까지 p2전진
				sum += arr[p2];
				p2++;
			}
			
			while(p1 < arr.length && sum >= S) {	//p2위치의 수를 더하기엔 이미 S를 넘으므로 p1을 전진시키며 S를 감소. 이때 S를 넘는 최소 연속 개수를 구한다.
				result = Math.min(result, p2 - p1);
				sum -= arr[p1];
				p1++;
			}
		}
		
		bw.write((result == Integer.MAX_VALUE ? 0 : result) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
