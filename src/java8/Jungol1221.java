package java8;

import java.util.Scanner;

//후위 표기법
//입력의 첫 줄에는 총 입력되는 연산자와 피연산자의 개수의 합 M(3≤M≤11 )이 입력되며, 그 다음줄에 M개의 연산자와 피연산자가 한 칸씩의 공백 을 두고 입력된다. 
//피연산자 X 는 0≤X≤9 의 범위를 가지는 정수이며, 연산자는 사칙연산인 '*', '/', '+', '-'의 네 가지가 입력된다. 0으로 나누는 경우는 입력되지 않는다.
public class Jungol1221 {
	static int stack[] = new int[6];
	static int top = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m;
		m = scanner.nextInt();
		int op1, op2;
		int pp;

		for (int i = 0; i < m; i++) {

			pp = scanner.next().charAt(0);
			switch (pp) {
			case '+':
				op1 = pop();
				op2 = pop();
				op1 = op1 + op2;
				push(op1);
				break;
			case '-':
				op1 = pop();
				op2 = pop();
				op1 = op2 - op1;
				push(op1);
				break;
			case '/':
				op1 = pop();
				op2 = pop();
				op1 = op2 / op1;
				push(op1);
				break;
			case '*':
				op1 = pop();
				op2 = pop();
				op1 = op1 * op2;
				push(op1);
				break;
			default:
				push(pp - 48);
				break;
			}
		}
		System.out.println(pop());
	}

	static boolean push(int a) {
		if (top == stack.length - 1) {
			return false;
		}
		top++;
		stack[top] = a;
		return true;
	}

	static int pop() {
		if (top == -1) {
			return -1;
		}
		int item;
		item = stack[top];
		top--;
		return item;
	}
}
