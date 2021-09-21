package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수들의 합2	(투 포인터)
public class BJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0, sum = 0, s = 0, e = 0;
		//두 개의 포인터 s와 e를 옮겨가며 arr[s] ~ arr[e - 1]까지의 합이 k보다 크면 e++ 아니면 s++를 하며 M이 될때 카운트한다.
		while(true) {
			if(sum >= M) {
				sum -= arr[s++];
			}else if(e == N) {
				break;
			}else {
				sum += arr[e++];
			}
			if(sum == M) {
				count++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
