package programmers;

import java.util.Stack;

//올바른 괄호
public class CorrectParentheses {
	public static void main(String[] args) {
		String[] s = {
				"()()",
				"(())()",
				")()(",
				"(()(",
		};
		for(int i = 0; i < s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}
	
	static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		stack.push('(');
        	}else {
        		if(stack.isEmpty()) {
        			answer = false;
        			break;
        		}
        		stack.pop();
        	}
        }
        if(!stack.isEmpty()) {
        	answer = false;
        }
        return answer;
    }
}
