package baekjoon.bj10000;

import java.util.Scanner;

//팩토리얼 (0 <= n <= 12)
public class BJ10872 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int f = 1;
		for(int i = 2; i <= n; i++) {
			f *= i;
		}
		System.out.println(f);
	}
}
