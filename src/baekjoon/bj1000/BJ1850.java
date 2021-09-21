package baekjoon.bj1000;

import java.util.Scanner;
//최대공약수3
public class BJ1850 {
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
		long g = gcd(a, b);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < g; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
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
