package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//팰린드롬인지 확인하기
public class BJ10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(isPalindrom(br.readLine()) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int isPalindrom(String str) {
		int s = 0, e = str.length() - 1;	//문자열의 시작, 끝 포인터
		while(s < e) {	
			if(str.charAt(s++) != str.charAt(e--)) {
				return 0;
			}
		}
		return 1;
	}
}
