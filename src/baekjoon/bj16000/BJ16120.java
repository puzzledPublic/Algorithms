package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//PPAP
public class BJ16120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			if(stack.size() < 3) {	//아직 3개가 안채워졌으면 계속 채운다.
				stack.push(str.charAt(i));
			}else {	//스택에 3개 이상인 경우
				if(str.charAt(i) == 'P') {	//현재 집어 넣으려는 문자가 'P'라면
					int size = stack.size() - 1;
					if(stack.get(size) == 'A' && stack.get(size - 1) == 'P' && stack.get(size - 1) == 'P') {	//이전에 PPA가 존재하는지 검사 맞다면 그 3개를 뺀다.
						stack.pop();
						stack.pop();
						stack.pop();
					}
				}
				stack.push(str.charAt(i));	//현재 문자를 집어 넣는다.
			}
		}
		
		if(stack.size() == 1 && stack.peek() == 'P') {	//'P' 하나만 남는 경우 PPAP 문자열이다.
			bw.write("PPAP\n");
		}else {	//그외의 경우 PPAP 문자열이 아니다.
			bw.write("NP\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
