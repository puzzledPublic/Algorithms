package java8;

import java.util.Scanner;

//여러 정수들의 최대 공약수, 최소 공배수
public class Jungol1002 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n, gcm, lcm;
		n = scanner.nextInt();

		if (n < 2 || n > 100) {
			System.exit(0);
		}

		int[] item = new int[n];

		for (int i = 0; i < n; i++) {
			item[i] = scanner.nextInt();
		}
		//처음 정수를 gcm, lcm 으로 지정
		gcm = lcm = item[0];
		//다음 정수와 gcm, lcm 구하는 것을 반복
		for (int i = 1; i < n; i++) {
			gcm = get_gcd(gcm, item[i]);
			lcm = lcm * item[i] / get_gcd(lcm, item[i]);

		}
		System.out.println(gcm +" "+ lcm);

	}
	//유클리드 호제법으로 gcm 구하는 함수
	static int get_gcd(int a, int b) {
		int r;

		while (true) {
			r = a % b;
			if (r == 0) {
				break;
			}
			a = b;
			b = r;
		}
		return b;
	}
}
