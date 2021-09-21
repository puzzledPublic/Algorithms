package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//음식 평론가
//정해는 GCD로 푸는방법
public class BJ1188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//소시지 개수
		int M = Integer.parseInt(st.nextToken());	//인원 수
		
		int result = 0;
		for(int i = 1; i <= N * M; i++) {	//소시지를 총 N * M만큼 나눌 수 있고 N씩 끊어 나눠주면 된다.
			if(i % N == 0 && i % M != 0) {	//M의 배수일 때는 각 소시지의 끝 지점이므로 자른 횟수를 세지 않는다.
				result++;
			}
		}		
		bw.write(result + "\n");
//		GCD를 사용한 방법
//		int result2 = M - gcd(N, M);
//		bw.write(result2 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
