package java8;

import java.util.Scanner;

//주사위 던지기 1
//주사위를 던진 횟수 N과 출력형식 M을 입력 받아서 M의 값에 따라 각각 아래와 같이 출력하는 프로그램을 작성하시오.
//M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
//M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
//M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
//* 중복의 예
//1 1 2 와 중복 : 1 2 1, 2 1 1
//1 2 3 과 중복 : 1 3 2, 2 1 3, 2 3 1, 3 1 2
//첫 줄에 주사위를 던진 횟수 N(2≤N≤5)과 출력모양 M(1≤M≤3)이 들어온다
//작은 숫자부터 출력
public class Jungol1169 {

	static int[] print = { 1, 0, 0, 0, 0, 0 };
	static boolean[] mask = new boolean[7];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;
		n = scanner.nextInt();
		m = scanner.nextInt();

		switch (m) {
		case 1:
			throwCoin(1, n);
			break;
		case 2:
			throwCoin2(1, n);
			break;
		case 3:
			throwCoin3(1, n);
			break;
		}
	}

	// M==1
	static void throwCoin(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			print[k] = i;
			throwCoin(k + 1, n - 1);
		}
	}

	// M==2
	static void throwCoin2(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = print[k - 1]; i <= 6; i++) {
			print[k] = i;
			throwCoin2(k + 1, n - 1);
		}
	}

	// M==3
	static void throwCoin3(int k, int n) {
		if (n == 0) {
			for (int i = 1; i < print.length; i++) {
				if (print[i] > 0) {
					System.out.print(print[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if (mask[i] == true) {
				continue;
			}
			print[k] = i;
			mask[i] = true;
			throwCoin3(k + 1, n - 1);
			mask[i] = false;
		}
		/*
		 * for (int i = 1; i <= 6; i++) { for(int j = 1 ; j < print.length;
		 * j++){ if(print[j] == i){ i++; } } print[k] = i; throwCoin3(k + 1, n -
		 * 1); }
		 */
	}

}
