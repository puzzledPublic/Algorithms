package java8;

import java.util.Scanner;
//별 삼각형 구하기
public class Jungol1719 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;// 삼각형 높이 100 이하 홀수
		int m; // 삼각형 종류 1~4 사이
		n = scanner.nextInt();
		m = scanner.nextInt();
		if(n%2==0||n>100||m<1||m>4){
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		switch (m) {
		case 1:
			option1(n);
			break;
		case 2:
			option2(n);
			break;
		case 3:
			option3(n);
			break;
		case 4:
			option4(n);
			break;
		}
	}

	public static void option1(int n) {
		for (int i = 1; i <= n / 2 + 1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= n / 2; i++) {
			for (int j = n / 2 - i + 1; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void option2(int n) {
		for (int i = 0; i < n / 2 + 1; i++) {
			for (int j = n / 2 - i; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = n / 2 - i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void option3(int n) {
		for (int i = 0; i < n / 2 + 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = n - (i * 2); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = n / 2 - i - 1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 3 + (i * 2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void option4(int n) {
		for (int i = 0; i < n / 2 + 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = n / 2 - i + 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
