package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//이런 반전이
//숫자가 3자리 수라고 하고 abc라고하자.
//100a + 10b + c로 나타낼 수 있고 문제에 따라 이 숫자의 반전은 100(9-a) + 10(9-b) + (9-c)가 된다.
//우리가 원하는 값인 이 둘의 곱을 풀어보면 (100a + 10b + c) * (999 - (100a + 10b + c))가 된다.
//100a + 10b + c를 N로 나타내면 N * (999 - N)가 된다.
//이는 위로 볼록한 2차 함수이며 최대값은 위의 식을 미분하면 -2N + 999 = 0이 되며 대략 N = 499일때 최대값을 갖는다.
//이에 따라 자리수가 높을 수록 그리고 같은 자리수에서 499...가 될때 최대값을 갖고 만약 N이 499...이상이 아니라면 N자체일때 최대값을 갖는다.
public class BJ11947 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String str = br.readLine();	//숫자 문자열
			int len = str.length();	//숫자의 길이
			
			StringBuilder sb = new StringBuilder("4");	//해당 자리수의 기준을 만든다. 4999....
			for(int j = 1; j < len; j++) {
				sb.append("9");
			}
			
			long N = Long.parseLong(str);
			long base = Long.parseLong(sb.toString());
			
			if(N >= base) {	//입력된 숫자가 기준을 넘는다면.
				bw.write((base * (base + 1)) + "\n");
			}else {
				sb = new StringBuilder();	//아니라면 입력된 숫자의 반전을 구해 곱해준다.
				for(int j = 0; j < len; j++) {
					sb.append("9");
				}
				long nines = Long.parseLong(sb.toString());
				bw.write((nines * N - N * N)  + "\n");	//(N * (99.. - N))
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
