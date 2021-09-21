package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//찾기 (KMP)
public class BJ1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine(), br.readLine());
	}
	
	static void solve(String n, String m) {
		int begin = 0, matched = 0, nLen = n.length(), mLen = m.length(), count = 0;
		int[] p = getPartialMatch(m);	//p[i] = m[0~i]의 접두사도 되고 접미사도 되는 문자열의 최대 길이
		StringBuilder sb = new StringBuilder();
		
		while(begin <= nLen - mLen) {
			if(matched < mLen && n.charAt(begin + matched) == m.charAt(matched)) {
				matched++;
				if(matched == mLen) {
					count++;
					sb.append((begin + 1)+"\n");
				}
			}else {
				if(matched == 0) {
					begin++;
				}else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
	static int[] getPartialMatch(String s) {
		int sLen = s.length();
		int[] p = new int[sLen];
		int begin = 1, matched = 0;
		while(begin + matched < sLen) {
			if(s.charAt(begin + matched) == s.charAt(matched)) {
				matched++;
				p[begin + matched - 1] = matched;
			}else {
				if(matched == 0) {
					begin++;
				}else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}
		return p;
	}
}
