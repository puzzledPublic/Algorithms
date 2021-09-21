package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//디지털 루트
public class BJ6378 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while(!(str = br.readLine()).equals("0")) {			
			bw.write(solve(str) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(String str) {	//최대 1000자리인 숫자이므로 문자열로 받는다.
		int t = 0;
		for(int i = 0; i < str.length(); i++) {		//1000자리의 숫자가 9로만 구성돼도 각 자리수를 합한 값은 9000이므로 int로 바꾼다.
			t += str.charAt(i) - '0';
		}
		if(t < 10) {
			return t;
		}
		while(t >= 10) {
			int s = t;
			t = 0;
			while(s > 0) {
				t += (s % 10);
				s /= 10;
			}
		}
		return t;
    }
}
