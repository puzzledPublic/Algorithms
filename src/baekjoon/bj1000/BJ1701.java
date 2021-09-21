package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Cubeditor
public class BJ1701 {
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i = 0; i < s.length(); i++) {	//인덱스가 0에서부터만 시작 되므로 모든 부분문자열을 구할 수 없으므로 0 이상에서 시작하는 문자열에서도 탐색한다.
			solve(s.substring(i));
		}
		System.out.println(max);
	}
	static void solve(String s) {	//p[i] = s[0 ~ i]까지의 접두사 접미사가 같은 최대 길이 
		int begin = 1, matched = 0, sLen = s.length();
		int[] p = new int[sLen];
		
		while(begin + matched < sLen) {
			if(s.charAt(begin + matched) == s.charAt(matched)) {
				matched++;
				max = Math.max(max, p[begin + matched - 1] = matched);
			}else {
				if(matched == 0) {
					begin++;
				}else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}
	}
}
