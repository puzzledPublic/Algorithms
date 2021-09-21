package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//암호 만들기
public class BJ1759 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		
		char[] candidate = new char[C];
		boolean[] chk = new boolean[C];
		for(int i = 0; i < C; i++) {
			candidate[i] = (char)br.read();
			br.read();
		}
		
		Arrays.sort(candidate);	//문자 정렬
		solve(candidate, chk, 0, 0, L, "", bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(char[] candidate, boolean[] chk, int next, int n, int L, String s, Writer w) throws IOException {
		if(n == L) {	//L개 문자로 만들고
			if(check(s)) {	//조건을 만족하면 암호 완성
				w.write(s + "\n");
			}
			return;
		}
		for(int i = next; i < candidate.length; i++) {
//			if(!chk[i]) {
//				chk[i] = true;
				solve(candidate, chk, i + 1, n + 1, L, s + candidate[i], w);
//				chk[i] = false;
//			}
		}
	}
	//완성된 암호에 모음과 자음의 개수가 만족하는지
	static boolean check(String s) {
		int a = 0, b = 0;
		for(int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			if(t == 'a' || t == 'e' || t == 'i' || t =='o' || t == 'u') {
				a++;
			}else {
				b++;
			}
		}
		if(a > 0 && b > 1) {
			return true;
		}
		return false;
	}
}
