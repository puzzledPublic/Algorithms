package baekjoon.bj1000;

import java.util.Scanner;

//더하기 사이클
public class BJ1110 {
	static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		solve();
	}
	static void solve() {
		int n = N, count = 1;
		n = next(n);
		while(n != N) {
			n = next(n);
			count++;
		}
		System.out.println(count);
	}
	static int next(int n) {
		int a = n % 10, b = (n / 10) % 10;
		return (a * 10) + ((a + b) % 10);
	}
}
