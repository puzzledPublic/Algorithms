package baekjoon.bj10000;

import java.util.Scanner;
//x 미만 수
public class BJ10871 {
	static int N, X;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		X = input.nextInt();
		for(int i = 0; i < N; i++) {
			int temp = input.nextInt();
			if(temp < X) {
				System.out.print(temp + " ");
			}
		}
	}
}
