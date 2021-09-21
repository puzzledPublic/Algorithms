package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//균형잡힌 세상
public class BJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		Stack<Character> stack = new Stack<>();
		while(!".".equals(str = br.readLine())) {
			boolean isGood = true;	//쌍이 맞는가
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == ']' || ch == ')') {	//오른쪽 괄호인 경우
					if(!stack.isEmpty() && stack.peek() == ch) {	//현재 괄호와 쌍이 맞으면 빼낸다.
						stack.pop();
					}else {	//안맞다면 flag 세우고 종료
						isGood = false;
						break;
					}
				}else if(ch == '[') {	//오른쪽 괄호인 경우
					stack.push(']');
				}else if(ch == '(') {
					stack.push(')');
				}
			}
			if(isGood && stack.isEmpty()) {	//쌍이 맞고 스택이 비었으면 올바른 괄호쌍
				bw.write("yes\n");
			}else {
				bw.write("no\n");
			}
			stack.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
