package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//좋은 단어
public class BJ3986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				if(stack.isEmpty()) {	//스택이 비었다면 넣는다.
					stack.push(str.charAt(j));
				}
				else if(stack.peek() == str.charAt(j)) {	//이전 문자와 같다면 스택에서 이전 문자를 제거한다.
					stack.pop();
				}else {	//이전 문자와 다르다면 스택에 넣는다.
					stack.push(str.charAt(j));
				}
			}
			if(stack.isEmpty()) {	//모두 비었다면 좋은 단어이다.
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
