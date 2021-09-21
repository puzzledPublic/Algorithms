package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//그룹 단어 체커
public class BJ1316 {
	static boolean[] alpha = new boolean[26];
	static int groupWord;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			solve(br.readLine());
			for(int j = 0; j < alpha.length; j++) {	//배열 초기화
				alpha[j] = false;
			}
		}
		System.out.println(groupWord);
	}
	static void solve(String s) {
		int i = 0;
		while(i < s.length()) {
			if(alpha[s.charAt(i) - 97]) {	//이미 연속된 알파벳이라면 종료
				return;
			}
			alpha[s.charAt(i) - 97] = true;	//연속 알파벳 표시
			while(s.length() > i + 1 && s.charAt(i + 1) == s.charAt(i)){	//다음 알파벳까지 이동
				i++;
			}
			i++;
		}
		groupWord++;
	}
}
