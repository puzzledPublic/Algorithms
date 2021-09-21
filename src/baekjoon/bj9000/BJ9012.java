package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;
//괄호
public class BJ9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			solve(br.readLine(), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(String s, Writer w) throws IOException {
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ')') {	// ')'이면 pop
				if(st.isEmpty()) {	//이미 비어있는 경우면 VPS가 아니다.
					w.write("NO\n");
					return;
				}
				st.pop();
			}else {	//'('이면 push
				st.push('(');
			}
		}
		if(st.isEmpty()) {	//스택이 비어있다면 VPS이다.
			w.write("YES\n");
		}else {	//남아있으면 VPS가 아니다.
			w.write("NO\n");
		}
	}
}
