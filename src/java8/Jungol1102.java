package java8;

import java.util.Scanner;

//스택
//3가지의 명령을 하는 스택을 만드시오
//"i a"는 a라는 수를 스택에 삽입. (1 <= a <= 10,000)
//"o"는 스택에서 데이트롤 빼고 그 데이터를 출력, 스택이 비어있다면 "empty"출력
//"c"는 스택에 쌓여있는 데이터의 개수를 출력
//입력: 첫 줄에 N이 주어진다 N은 주어진느 명령의 수(1<= N <= 100)
//     N+1줄까지 N개의 명령이 주어진다.
public class Jungol1102 {
	static int stack[] = new int[101];
	static int top = -1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, number;
		n = scanner.nextInt();
		char instruction;
		for(int i = 0; i < n; i++){
			instruction = scanner.next().charAt(0);
			switch(instruction){
			case 'i':
				number = scanner.nextInt();
				push(number);
				break;
			case 'o':
				number = pop();
				if(number == -1){
					System.out.println("empty");
				}else{
					System.out.println(number);
				}
				break;
			case 'c':
				System.out.println(top+1);
				break;
			}
		}
		
	}
	static boolean push(int a){
		if(top == stack.length-1){
			return false;
		}
		top++;
		stack[top] = a;
		return true;
	}
	static int pop(){
		if(top == -1){
			return -1;
		}
		int item;
		item = stack[top];
		top--;
		return item;
	}
}
