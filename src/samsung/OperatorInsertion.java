package samsung;

import java.util.Scanner;

//연산자 끼워넣기 (백준 14888)
public class OperatorInsertion {
	static int N, Max = -987654321, Min = 987654321;	
	static int[] numbers;
	static int[] operators = new int[4]; // +, -, *, /
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = input.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			operators[i] = input.nextInt();
		}
		solve(1, numbers[0]);
		System.out.println(Max);
		System.out.println(Min);
	}
	static void solve(int op, int r) {
		if(op == N) {
			if(Max < r) {
				Max = r;
			}
			if(Min > r) {
				Min = r;
			}
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(operators[i] > 0) {
				--operators[i];
				solve(op + 1, operating(r, numbers[op], i));
				++operators[i];
			}
		}
	}
	
	static int operating(int l, int r, int type) {
		int result = 0;
		switch(type) {
		case 0:
			result = l + r;
			break;
		case 1:
			result = l - r;
			break;
		case 2:
			result = l * r;
			break;
		case 3:
			result = l / r;
			break;
		}
		return result;
	}
}
