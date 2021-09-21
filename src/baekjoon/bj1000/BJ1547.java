package baekjoon.bj1000;

import java.util.Scanner;

//공
public class BJ1547 {
	static int M;
	static int[] cup = {0, 1, 2, 3};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		M = input.nextInt();
		int a, b;
		for(int i = 0; i < M; i++) {
			a = input.nextInt();
			b = input.nextInt();
			int temp = cup[a];
			cup[a] = cup[b];
			cup[b] = temp;
		}
		for(int i = 1; i < 4; i++) {
			if(cup[i] == 1) {
				System.out.println(i);
			}
		}
	}
}
