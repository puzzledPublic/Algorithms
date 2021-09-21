package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//쿼드트리
public class BJ1992 {
	static String[] quadTree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		quadTree = new String[N];
		for(int i = 0; i < N; i++) {
			quadTree[i] = br.readLine();
		}
		solve(N, 0, 0, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int x, int y, Writer w) throws IOException {
		if(n == 1 || check(n, x, y)) {
			w.write(quadTree[x].charAt(y));
			return;
		}else {
			int next = n / 2;
			w.write("(");
			solve(next, x, y, w);
			solve(next, x, y + next, w);
			solve(next, x + next, y, w);
			solve(next, x + next, y + next, w);
			w.write(")");
		}
	}
	
	static boolean check(int n, int x, int y) {
		String s = quadTree[x].substring(y, y + n);
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i - 1) != s.charAt(i)) {
				return false;
			}
		}
		for(int i = x + 1; i < x + n; i++) {
			if(!s.equals(quadTree[i].substring(y, y + n))){
				return false;
			}
		}
		return true;
	}
}
