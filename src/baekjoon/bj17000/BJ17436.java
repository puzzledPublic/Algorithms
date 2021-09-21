package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//소수의 배수
//포함배제의 원리를 이용한다. (https://ko.wikipedia.org/wiki/%ED%8F%AC%ED%95%A8%EB%B0%B0%EC%A0%9C%EC%9D%98_%EC%9B%90%EB%A6%AC)
//(A∪B) = A + B - (A∩B)
//(A∪B∪C) = A + B + C - ((A∩B) + (A∩C) + (B∩C)) + (A∩B∩C)를 N개의 집합에 대해 일반화.
public class BJ17436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long result = 0;
		for(int i = 1; i < (1 << N); i++) {
			int count = 0;
			long mul = 1;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					count++;
					mul *= arr[j];
				}
			}
			if(count % 2 != 0) {
				result += (M / mul);
			}else {
				result -= (M / mul);
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
