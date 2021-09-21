package baekjoon.bj2000;

import java.util.Scanner;

//최대공약수와 최소공배수
public class BJ2609 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		solve(input.nextInt(), input.nextInt());
	}
	static void solve(int a, int b) {
		if(a < b) {
			int temp = b;
			b = a;
			a = temp;
		}
		int g = gcd(a, b);
		System.out.println(g);
		System.out.println(a * b / g);
	}
	static int gcd(int a, int b) {
		int c;
		while(b > 0) {
			c = b;
			b = a % c;
			a = c;
		}
		return a;
	}
}
