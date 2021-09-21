package baekjoon.bj2000;

import java.util.Scanner;
//지능형 기차
public class BJ2455 {
	static int max;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.nextInt();
		max = input.nextInt();
		int c = max;
		for(int i = 1; i < 4; i++) {
			c -= input.nextInt();
			c += input.nextInt();
			if(max < c) {
				max = c;
			}
		}
		System.out.println(max);
	}
}
