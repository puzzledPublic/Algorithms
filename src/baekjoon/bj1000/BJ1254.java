package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//팰린드롬 만들기 (Manacher's algorithms으로 O(n)에 가능)
public class BJ1254 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		int len = S.length();
		char[] ch = new char[len * 2];
		for(int i = 0; i < len; i++) {
			ch[i] = S.charAt(i);
		}
		
		int result = -1;
		for(int i = 0; i < len; i++) {	//S의 문자열을 하나씩 늘려가며 팰린드롬이 되는지 검사한다.
			int tlen = len + i;
			int k = 0;
			for(int j = tlen - 1; j >= len ; j--) {	//팰린드롬이어야 하므로 뒤에 이어지는 문자들은 S의 접두사를 뒤집은것과 같다.
				ch[j] = ch[k++];
			}
			if(isPalindrom(ch, tlen)) {	//팰린드롬인지 검사
				result = tlen;
				break;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPalindrom(char[] ch, int len) {
		int s = 0, e = len - 1;
		while(s < e) {
			if(ch[s++] != ch[e--]) {
				return false;
			}
		}
		return true;
	}
}
