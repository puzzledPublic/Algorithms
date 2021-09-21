package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//쇠막대기
public class BJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i + 1 < s.length() && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {	//레이저인 경우
				result += stack.size();
				i++;
			}else if(s.charAt(i) == '(') {	//막대기 시작
				stack.push('(');
			}else{	//막대기 끝
				result++;
				stack.pop();
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
