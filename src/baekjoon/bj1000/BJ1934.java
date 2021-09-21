package baekjoon.bj1000;

import java.util.Scanner;

//최소 공배수 1
public class BJ1934 {
	static int T;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		for(int i = 0; i < T; i++) {
			solve(input.nextInt(), input.nextInt());
		}
	}
	static void solve(int a, int b) {
		int g = gcd(a, b);
		System.out.println(a * b / g);
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
