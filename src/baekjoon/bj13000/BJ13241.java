package baekjoon.bj13000;

import java.util.Scanner;

//최소 공배수2
public class BJ13241 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		solve(input.nextLong(), input.nextLong());
	}
	static void solve(long a, long b) {
		if(a < b) {
			long temp = b;
			b = a;
			a = temp;
		}
		System.out.println(a * b / gcd(a,b));
	}
	static long gcd(long a, long b) { 
		long c;
		while(b > 0) {
			c = b;
			b = a % c;
			a = c;
		}
		return a;
	}
}
