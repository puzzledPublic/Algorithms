package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

//괄호의 값
public class BJ2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		solve(br.readLine(), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(String s, Writer w) throws IOException {	//곱셈의 분배법칙을 이용하자.
		Stack<Character> st = new Stack<>();					// ((())[[]])인 경우 2*(2*(2) + 3*(3))으로 나타낼수 있고 이는 2*(2*(2)) + 2*(3*(3))처럼 분배법칙이 된다.
		int tmp = 1, sum = 0;									// 괄호가 열릴때는 각 괄호에 맞는 숫자를 곱하여 분배법칙 하듯이 진행하고 괄호가 닫힐때 현재까지 숫자를 저장후 다음 숫자를 위해 각 괄호에 맞는 숫자로 나눈다.
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case '(':	// '('인 경우 (열리는 경우) 2배를 한다.
				tmp *= 2;
				st.push('(');
				break;
			case '[':	// '['인 경우 3배를 한다.
				tmp *= 3;
				st.push('[');
				break;
			case ')':	// ')'인 경우 (닫히는 경우)
				if(i - 1 >= 0 && s.charAt(i - 1) == '(') { //닫히는게 맞다면
					sum += tmp;
				}
				if(st.isEmpty()) {	//아무것도 없는 경우 올바른 괄호가 아님
					w.write("0\n");
					return;
				}
				if(st.peek() == '(') {	//괄호쌍을 지운다.
					st.pop();
				}
				tmp /= 2;
				break;
			case ']':	// ']'인 경우
				if(i - 1 >= 0 && s.charAt(i - 1) == '[') {
					sum += tmp;
				}
				if(st.isEmpty()) {
					w.write("0\n");
					return;
				}
				if(st.peek() == '[') {
					st.pop();
				}
				tmp /= 3;
				break;
			}
		}
		if(st.isEmpty()) {
			w.write(sum + "\n");
		}else {
			w.write("0\n");
		}
	}
}
