package programmers;

import java.util.Stack;

//큰 수 만들기
public class MakingBigNumber {
	public static void main(String[] args) {
		String[] number = {"1924", "1231234", "4177252841", "9817"};
		int[] k = {2, 3, 4, 2};
		
		for(int i = 0; i < number.length; i++) {			
			System.out.println(solution(number[i], k[i]));
		}
	}
	
	static String solution(String number, int k) {
		String answer = "";
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < number.length(); i++) {
			while(!stack.isEmpty() && stack.peek() - '0' < number.charAt(i) - '0' && k > 0) {	//현재 숫자보다 스택에 작은 숫자들을 빼낸다.
				stack.pop();
				k--;
			}
			stack.push(number.charAt(i));
		}
		while(k > 0) {	//아직 k개를 지우지 않았다면 stack은 현재 내림차순이므로 맨 마지막것부터 빼낸다.
			stack.pop();
			k--;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		answer = sb.reverse().toString();
		return answer;
	}
	
/*	static String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.add(number.charAt(i));
        	}else {
        		while(!stack.isEmpty() && stack.peek() - '0' < number.charAt(i) - '0') {
        			stack.pop();
        			k--;
        			if(k == 0) {
        				break;
        			}
        		}
        		stack.add(number.charAt(i));
        	}
        	if(k == 0) {
        		while(!stack.isEmpty()) {
        			sb.append(stack.pop());
        		}
        		sb.reverse().append(number.substring(i + 1));
        		break;
        	}
        }
        if(k > 0) {
	        while(k > 0) {
	        	stack.pop();
	        	k--;
	        }
	        while(!stack.isEmpty()) {
	        	sb.append(stack.pop());
	        	sb.reverse();
	        }
        }
        
        answer = sb.toString();
        return answer;
    }*/
}
