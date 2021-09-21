package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//회문
public class BJ17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			int s = 0, e = str.length() - 1;
			while(s < e) {	//팰린드롬인지 검사
				if(str.charAt(s) != str.charAt(e)) break;
				s++;
				e--;
			}
			
			int result = 0;
			if(s < e) {	//원래 문자열이 팰린드롬이 아니고
				if(isPalindrom(str.substring(s + 1, e + 1)) || isPalindrom(str.substring(s, e))) {	//한글자를 지운 상태의 문자열 두개 중 하나가 팰린드롬이라면 유사 팰린드롬
					result = 1;
				}else {	//두 문자열 모두 팰린드롬이 아니라면 일반 문자열
					result = 2;
				}
			}
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPalindrom(String str) {	//팰린드롬인가?
		int s = 0, e = str.length() - 1;
		while(s < e) {
			if(str.charAt(s) != str.charAt(e)) return false;
			s++;
			e--;
		}
		return true;
	}
}
