package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
//KMP는 왜 KMP일까?
public class BJ2902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		solve(br.readLine(), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(String s, Writer w) throws IOException {
		w.write(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i - 1) == '-') {
				w.write(s.charAt(i));
			}
		}
		w.write("\n");
	}
}
