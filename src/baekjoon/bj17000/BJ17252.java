package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//삼삼한 수
public class BJ17252 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		if(N == 0) {	//0이면 삼삼한 수 아님
			bw.write("NO\n");
		}else {
			int prevPow = -1;	//바로 전 제곱 횟수
			boolean isSamSam = true;	//제곱이 중복되는지 확인
			while(N > 3) {
				long i = 1;
				int pow = 0;
				while(i <= N) {	//N이하까지 3의 제곱을 구한다.
					i *= 3;
					pow++;
				}
				pow--;
				N -= i / 3;
				if(pow == prevPow) {	//이전 제곱과 횟수가 같다면 fail
					isSamSam = false;
					break;
				}
				prevPow = pow;
			}
			if(!isSamSam || N == 2 || (prevPow == 1 && N == 3)) {	//제곱이 중복, N == 2, 이전 제곱 횟수가 1이면서 N이 3이라면 이것도 제곱이 중복이므로 fail
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
