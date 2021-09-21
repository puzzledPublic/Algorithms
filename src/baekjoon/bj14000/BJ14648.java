package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//쿼리 맛보기
public class BJ14648 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N + 1];	//숫자들
		long[] sum = new long[N + 1];	//부분합
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + arr[i];
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			if(t == 1) {	//1 a b => a번째 ~ b번째 숫자들의 합을 출력하고 a번째 b번째 위치의 숫자를 교환
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				bw.write((sum[b] - sum[a - 1]) + "\n");	//합 출력
				
				for(int j = a; j < b; j++) {	//숫자를 교환하면 부분합도 수정해야한다.
					sum[j] += arr[b] - arr[a];
				}
				
				long tmp = arr[b];	//교환
				arr[b] = arr[a];
				arr[a] = tmp;
				
			}else {	//2 a b c d => a번째 ~ b번째 숫자들의 합과 c번째 ~ d번째 숫자들의 합의 차이를 출력
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				bw.write(((sum[b] - sum[a - 1]) - (sum[d] - sum[c - 1])) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
