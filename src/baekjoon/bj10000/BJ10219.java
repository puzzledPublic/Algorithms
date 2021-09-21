package baekjoon.bj10000;

import java.util.Arrays;
import java.util.Scanner;

//Meats On the Grill
public class BJ10219 {
	static int T;
	static char[][] grill = new char[11][];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		int h, w;
		for(int i = 0; i < T; i++) {
			h = input.nextInt();
			w = input.nextInt();
			input.nextLine();
			for(int k = 0; k < h; k++) {
				grill[k] = input.nextLine().toCharArray();
			}
			solve(h, w);
		}	
	}
	static void solve(int h, int w) {	//불판 자체를 뒤집자
		for(int i = h - 1; i >= 0; i--) {
			for(int j = 0; j < w; j++) {
				System.out.print(grill[i][j]);
			}
			System.out.println();
		}
	}
}
