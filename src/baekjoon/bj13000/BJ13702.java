package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이상한 술집
public class BJ13702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long start = 1, end = 1;

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(end < arr[i]) {
				end = arr[i];
			}
		}
		end++;	//start <= mid < end + 1가 되도록, 막걸리 용량이 최대 2^31-1까지의 입력이 있다. 거기에 1을 더한 2^31은 int타입으로는 오버플로우가 나므로 long타입으로 선언했다.
		
		while(start + 1 < end) {	//mid만큼의 용량으로 막걸리를 K명 이상으로 나눌 수 있는가?
			long mid = (start + end) / 2;
			int count = 0;
			for(int i = 0; i < N; i++) {
				count += (arr[i] / mid);
			}
			
			if(count < K) {	//K보다 더 적다면 용량을 줄이는 쪽으로
				end = mid;
			}else {			//K보다 더 크다면 용량을 키우는 쪽으로
				start = mid;
			}
		}
		
		bw.write(start + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
