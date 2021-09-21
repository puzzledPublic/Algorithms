package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//문자열 폭발
public class BJ9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		solve(br.readLine(), br.readLine());
		
		br.close();
	}
	
	static void solve(String source, String bomb) {		
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		char lastBomb = bomb.charAt(bomb.length() - 1);	//bomb 마지막 글자
		for(int i = 0; i < source.length(); i++) {	//문자열을 순회
			stack.add(source.charAt(i));	//일단 스택에 넣는다.
			if(!stack.isEmpty() && source.charAt(i) == lastBomb) {	//마지막 글자면
				if(bomb.length() == 1) {	//bomb문자열 길이가 1이면 그냥 pop
					stack.pop();
				}else {						//bomb문자열 길이가 2이상이면
					int index = stack.size() - 1;	//스택 마지막부터
					for(int j = bomb.length() - 1; j >= 0; j--) {	//bomb문자열 길이만큼 
						if(index == -1 || stack.get(index--) != bomb.charAt(j)) {	//각각의 문자가 맞는지 검사.
							flag = true;	//문자열이 bomb이 아니면 flag를 false로
							break;
						}
					}
					if(!flag) {		//bomb이라면 bomb 길이만큼 pop
						for(int j = 0; j < bomb.length(); j++) {
							stack.pop();
						}
					}
					flag = false;	//flag 재초기화
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) {
			sb.append("ALURF");
		}else {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
		System.out.println(sb.reverse());
	}
}
