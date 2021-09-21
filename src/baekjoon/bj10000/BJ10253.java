package baekjoon.bj10000;

import java.util.Scanner;

//헨리
public class BJ10253 {
	static int T;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		int a, b;
		for(int i = 0; i < T; i++) {
			a = input.nextInt();
			b = input.nextInt();
			solve(a, b);
		}
	}
	
	static void solve(int a, int b) {
		int c;
		while(true) {
			if(b % a == 0) {	//나누어 떨어지는 경우 1 / c 로 끝
				c = b / a;
				a = 1;
				b = c;
			}else {	// 다음 a, b는 a/b - 1/c에 의해 정해진다.
				c = (b / a) + 1;
				int ta = a, tb = b;
				a = ta * c - tb;
				b = tb * c;
			}
			if(a == 1) {
				System.out.println(b);
				break;
			}
		}
	}
}
