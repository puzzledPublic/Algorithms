package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//극적인 곱셈
public class BJ1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N > K) { 
			bw.write("0\n");
		}else {
			long n = N, k = K;
			//현재 수의 마지막 숫자 K는 현재 수에 N을 곱했을때 수의 맨 처음 숫자가 된다.
			//K를 N으로 나눈 몫을 K뒤에 붙여가며 이를 반복한다.
			//나눈 몫이 K와 같고 나머지가 0이라면 종료.
			while(true) {
				long last = (k / n);
				long left = (k % n);
				bw.write(last + "");
				k = left * 10 + last;
				if(last == K && left == 0) break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
