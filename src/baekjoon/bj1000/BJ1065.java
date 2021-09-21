package baekjoon.bj1000;

import java.util.Scanner;

//한수
public class BJ1065 {
	static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		int result = 99;
		if(N < 100) {	//99까지는 모두 등차수열을 이룬다.
			System.out.println(N);
		}else {
			for(int i = 100; i < N; i++) {	//100 ~ 1000까지에 대해 등차수열을 이루는지 검사
				if(solve(i)) {
					System.out.println(i);
					result++;
				}
			}
			System.out.println(result);
		}
	}
	static boolean solve(int n) {	//처음 등차를 구하고 나머지 자리수에 대해 등차수열이 맞는지 검사
		int a,b, d;
		a = n % 10;
		n /= 10;
		b = n % 10;
		d = a - b;
		while(n > 9) {
			a = n % 10;
			n /= 10;
			b = n % 10;
			if(d != a - b) {
				return false;
			}
		}
		return true;
	}
}
