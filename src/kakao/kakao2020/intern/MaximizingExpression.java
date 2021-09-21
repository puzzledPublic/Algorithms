package kakao.kakao2020.intern;

import java.util.Deque;
import java.util.LinkedList;

//수식 최대화
public class MaximizingExpression {
	public static void main(String[] args) {
		String[] expressions = {
				"100-200*300-500+20",
				"50*6-3*2",
		};
		for(int i = 0; i < expressions.length; i++) {
			System.out.println(solution(expressions[i]));
		}
	}
	
	static long solution(String expression) {
        long answer = 0;
        
        char[][] opOrder = {
        		{'*', '+', '-'}, {'*', '-', '+'}, {'+', '*', '-'}, {'+', '-', '*'}, {'-', '*', '+'}, {'-', '+', '*'}
        };
        
        String[] numStr = expression.split("[*+-]");
        String[] op = expression.split("[0-9]+");
        
        for(int i = 0; i < opOrder.length; i++) {
        	Deque<Long> numDeque = new LinkedList<>();
        	Deque<Character> opDeque = new LinkedList<>();
        	for(int j = 0; j < numStr.length; j++) {
        		numDeque.add(Long.parseLong(numStr[j]));
        	}
        	for(int j = 1; j < op.length; j++) {
        		opDeque.add(op[j].charAt(0));
        	}
        	
        	for(int j = 0; j < 3; j++) {
	        	int opSize = opDeque.size();
	        	for(int k = 0; k < opSize; k++) {
	        		char oper = opDeque.poll();
	        		if(oper == opOrder[i][j]) {
	        			numDeque.addFirst(calc(numDeque.poll(), numDeque.poll(), oper));
	        		}else {
	        			numDeque.add(numDeque.poll());
	        			opDeque.add(oper);
	        		}
	        	}
	        	numDeque.add(numDeque.poll());
        	}
        	answer = Math.max(answer, Math.abs(numDeque.peek()));
        }
        return answer;
    }
	
	static long calc(long a, long b, char op) {
		switch(op) {
			case '*':
				return a * b;
			case '+':
				return a + b;
			default:
				return a - b;
		}
	}
}
