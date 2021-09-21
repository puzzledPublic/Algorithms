package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//K번째 수
public class BJ1300 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		long K = Integer.parseInt(br.readLine());
		
		long start = 1, end = N * N;	//K로 상한을 잡아도 성립한다.
		
		while(start < end) {	//(이분탐색) mid가 k번째 이상의 원소인가?
			
			long mid = (start + end) / 2L;
			long count = 0;	//NxN 행렬에서 mid보다 작은 원소의 개수
			
			//문제 정의에 따라 NxN의 행렬에서 각 행(i)은 i배수 수열이 된다. 
			//그러므로 각 행의 mid보다 작은 원소의 개수는 mid / i로 알 수 있다.
			//주의할 점은 각 행당 mid보다 작은 원소 개수는 최대 N개인데 (mid / i) > N이 될 수 있으므로 min(N, (mid / i))개 여야한다.
			for(int i = 1; i <= N; i++) {
				count += Math.min(N, (mid / i));
			}
			
			if(count >= K) {	//mid보다 작은 원소 개수가 K개 보다 크면 mid를 낮춰본다.
				end = mid;
			}else {	//아니라면 mid를 높여본다.
				start = mid + 1;
			}
		}
		
		bw.write(start + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
