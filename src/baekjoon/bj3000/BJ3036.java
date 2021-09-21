package baekjoon.bj3000;

import java.util.Scanner;

//링
//start만큼 next가 돌아야한다. 
//출력이 start / next 인 기약분수 형태이므로 start, next의 최대공약수로 각각 start, next를 나누면 된다.
public class BJ3036 {
	static int N, start, next;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		start = input.nextInt();
		int g;
		for(int i = 1; i < N; i++) {
			next = input.nextInt();
			if(start < next) {
				g = gcd(next, start);
			}else {
				g = gcd(start, next);
			}
			System.out.println((start / g) + "/" + (next / g));
		}
	}

	static int gcd(int a, int b) {
		int c;
		while(b > 0) {
			c = b;
			b = a % c;
			a = c;
		}
		return a;
	}
}
