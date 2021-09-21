package baekjoon.bj2000;

import java.util.Scanner;
//설탕 배달
public class BJ2839 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		solve(n);
	}
	static void solve(int n) {
		int k = n / 5;
		for(int i = k; i >= 0; i--) {
			if((n - (i * 5)) % 3 == 0) {
				System.out.println(i + ((n - (i * 5)) / 3));
				return;
			}
		}
		System.out.println(-1);
	}
}
