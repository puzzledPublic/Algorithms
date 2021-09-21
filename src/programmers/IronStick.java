package programmers;

import java.util.Stack;

//쇠막대기
public class IronStick {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		
		System.out.println(solution(arrangement));
	}
	
	static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arrangement.length(); i++) {
        	if(arrangement.charAt(i) == '(' && arrangement.charAt(i + 1) == ')') {
        		i++;
        		answer += stack.size();
        	}else if(arrangement.charAt(i) == '(') {
        		stack.add('(');
        	}else {
        		stack.pop();
        		answer++;
        	}
        }
        return answer;
    }
}
