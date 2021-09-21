package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//정수 게임 (포함배제의 원리를 이용한다, BJ17436과 비슷한 문제)
public class BJ14848 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i = 1; i < (1 << K); i++) {	//K개중 1개 ~ K개를 고르는 경우를 모두 시도
			int count = 0;
			long LCM = 1;
			for(int j = 0; j < K; j++) {
				if((i & (1 << j)) > 0) {
					count++;
					LCM = lcm(LCM, arr[j]);	//고른 숫자들의 최소 공배수를 구한다.
				}
			}
			
			if(count % 2 == 0) {	//짝수개면 빼고
				result -= (N / LCM);
			}else {	//홀수개면 더한다.
				result += (N / LCM);
			}
		}
		
		bw.write((N - result) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
}