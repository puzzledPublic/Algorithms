package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어 공부
public class BJ1157 {
	static int[] alpha = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine());
	}
	static void solve(String s) {
		s = s.toLowerCase();	//문자열을 모두 소문자로
		int max = 0, index = 0, c = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i) - 97;	
			alpha[c]++;	//해당 알파벳 숫자 + 1
			if(alpha[c] > max) {	//현재 제일 많은 알파벳은?
				max = alpha[c];
				index = c;
			}
		}
		for(int i = 0; i < alpha.length; i++) {	//알파벳 갯수가 같은게 있는지?
			if(i != index && alpha[i] == max) {
				System.out.println("?");
				return;
			}
		}
		System.out.println((char)(index + 65));
	}
}
