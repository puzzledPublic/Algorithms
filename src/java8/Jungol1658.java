package java8;

import java.util.Scanner;

//최대 공약수와 최소 공배수
public class Jungol1658 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		int lcm;
		a = scanner.nextInt();
		b = scanner.nextInt();
		// 두 수의 곱은 두 수의 최대 공약수와 최소 공배수의 곱이다
		lcm = a * b / get_GCD(a, b);
		System.out.println(lcm);
		scanner.close();
	}

	// 유클리드 호제법으로 최대공약수를 구한다
	// GCD(a , b) == GCD(b , a % b)와 같다
	static int get_GCD(int a, int b) {
		int r;

		while (true) {
			r = a % b;
			if (r == 0) {
				break;
			}
			a = b;
			b = r;

		}
		System.out.println(b);
		return b;
	}
}
