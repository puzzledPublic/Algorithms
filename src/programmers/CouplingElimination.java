package programmers;

import java.util.Stack;

//짝지어 제거하기
public class CouplingElimination {
	public static void main(String[] args) {
		String[] s = {
				"baabaa",
				"cdcd",
		};
		for(int i = 0; i < s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}
	
	static int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.push(s.charAt(i));	//스택이 비었다면 추가
        	}else {
        		if(stack.peek() == s.charAt(i)) {	//바로 전 문자와 현재문자가 동일하면 2개가 연속이므로 제거
        			stack.pop();
        		}else {
        			stack.push(s.charAt(i));	//아니라면 스택에 추가
        		}
        	}
        }
        
        return answer = stack.isEmpty() ? 1 : 0;	//스택이 비었다면 제거 가능.
    }
}
