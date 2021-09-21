package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//유진수
public class BJ1356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		boolean isUjinsu = false;
		for(int i = 0; i < str.length() - 1; i++) {
			String left = str.substring(0, i + 1);	//숫자 문자열에서 i 인덱스를 기준으로 left, right로 나눈다.
			String right = str.substring(i + 1, str.length());
			int l = 1, r = 1;
			for(int j = 0; j < left.length(); j++) {	//왼쪽 숫자들의 곱
				l *= left.charAt(j) - '0';
			}
			for(int j = 0; j < right.length(); j++) {	//오른쪽 숫자들의 곱
				r *= right.charAt(j) - '0';
			}
			if(l == r) {	//숫자들이 서로 같다면 유진수이므로 종료.
				isUjinsu = true;
				break;
			}
		}
		
		bw.write((isUjinsu ? "YES\n" : "NO\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
