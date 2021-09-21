package java8;

import java.util.Scanner;
//각 자리수의 합
public class Jungol2812 {

	public static void main(String args[]) {
		long input;
		int sum = 0;
		long di;
		Scanner scanner = new Scanner(System.in);

		input = scanner.nextLong();

		do {
			sum = 0;
			while (input > 0) {
				di = input % 10;
				input /= 10;
				sum += di;
			}
			input = sum;
			System.out.println(sum);
		} while (sum > 10);

		scanner.close();
	}
}
