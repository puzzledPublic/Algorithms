package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//신용카드 판별
public class BJ14762 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			long n = Long.parseLong(br.readLine());
			int sum = 0;
			for(int j = 0; j < 16; j++) {
				if(j % 2 == 0) {	//홀수번째 숫자인 경우
					sum += n % 10;	//그 숫자를 더한다.
				}else {				//짝수번째 숫자인 경우
					long tmp = (n % 10) * 2;	//그 숫자에 2를 곱한다.
					sum += (tmp % 10 + tmp / 10);	//2를 곱한 숫자의 각 자리 숫자를 더한다.
				}
				n /= 10;
			}
			if(sum % 10 == 0) {
				bw.write("T\n");
			}else {
				bw.write("F\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
