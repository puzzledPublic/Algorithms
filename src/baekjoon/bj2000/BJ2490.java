package baekjoon.bj2000;

import java.util.Scanner;

//윷놀이
public class BJ2490 {
	static int a;
	static char r;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			a = 0;
			for(int j = 0; j < 4; j++) {
				a += input.nextInt();
			}
			switch (a) {
			case 0:
				r = 'D';
				break;
			case 1:
				r = 'C';
				break;
			case 2:
				r = 'B';
				break;
			case 3:
				r = 'A';
				break;
			default:
				r = 'E';
				break;
			}
			System.out.println(r);
		}
	}
}
