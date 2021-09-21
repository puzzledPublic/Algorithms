package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//약수의 합
public class BJ17425 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] sum = new long[1000001];
		
//		1~1000000의 각 수에 대해 약수들의 합들을 구하고 부분합을 구하면 시간초과...
//		for(int i = 1; i <= 1000000; i++) {
//			for(int j = 1; j * j <= i; j++) {
//				if(i % j == 0) {
//					sum[i] += j;
//					if(i / j != j) {
//						sum[i] += (i / j);
//					}
//				}
//			}
//		}

		//배수를 이용해 각 수의 약수들의 합을 구한다.
		for(int i = 1; i <= 1000000; i++) {
			for(int j = 1; j <= 1000000 / i; j++) {
				sum[i * j] += i;	//i는 i * j의 약수이다.
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= 1000000; i++) {	//1~n까지 각 약수들의 합의 총 합을 구하기 위한 부분합
			sum[i] += sum[i - 1];
		}
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write(sum[N] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
