package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//8진수 2진수
public class BJ1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String octet = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < octet.length(); i++) {
			int n = octet.charAt(i) - 48;	//8진수의 각 자리 숫자.
			int a, b, c;	//8진수 각 자리 숫자를 나눠가며 2진수(3bit)로 변환한다.
			c = n % 2;		
			n /= 2;
			b = n % 2;
			a = n / 2;
			sb.append(a).append(b).append(c);
		}
		
		//2진수로 변환했을때 0을 제외하고는 앞자리가 0이 되지 않도록 만든다.
		int i = 0;
		while(i < sb.length() && sb.charAt(i++) == '0');
		
		bw.write(sb.substring(i - 1));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
