package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//팬그램
public class BJ5704 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String s = br.readLine();
			if(s.charAt(0) == '*'){
				break;
			}
			solve(s, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(String s, Writer w) throws IOException {
		int[] alpha = new int[26];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ') {
				alpha[s.charAt(i) - 'a']++;
			}
		}
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] == 0) {
				w.write("N\n");
				return;
			}
		}
		w.write("Y\n");
	}
}
