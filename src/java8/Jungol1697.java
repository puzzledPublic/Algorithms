package java8;

import java.util.Scanner;

//큐
//"i a"는 a라는 수를 큐에 삽입. (1 <= a <= 10,000)
//"o"는 큐에서 데이터롤 빼고 그 데이터를 출력, 큐가 비어있다면 "empty"출력
//"c"는 큐에 쌓여있는 데이터의 개수를 출력
//입력: 첫 줄에 N이 주어진다 N은 주어진느 명령의 수(1<= N <= 100)
//   N+1줄까지 N개의 명령이 주어진다.
public class Jungol1697 {
	static int queue[] = new int[101];
	static int head = 0;
	static int rear = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, number;
		n = scanner.nextInt();
		char instruction;
		for (int i = 0; i < n; i++) {
			instruction = scanner.next().charAt(0);
			switch (instruction) {
			case 'i':
				number = scanner.nextInt();
				push(number);
				break;
			case 'o':
				number = pop();
				if (number == -1) {
					System.out.println("empty");
				} else {
					System.out.println(number);
				}
				break;
			case 'c':
				if (head < rear) {
					System.out.println(rear - head);
				} else {
					System.out.println(rear + queue.length - head + 1);
				}
			}
		}
	}

	static boolean push(int number) {
		if (head == (rear + 1) % queue.length) {
			return false;
		}
		queue[rear] = number;
		rear = (rear + 1) % queue.length;
		return true;
	}

	static int pop() {
		if (head == rear) {
			return -1;
		}
		int item = queue[head];
		head = (head + 1) % queue.length;
		return item;
	}
}
