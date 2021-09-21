package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문자열 반복
public class BJ2675 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			solve(Integer.parseInt(st.nextToken()), st.nextToken());
		}
	}
	static void solve(int len, String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < len; j++) {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
