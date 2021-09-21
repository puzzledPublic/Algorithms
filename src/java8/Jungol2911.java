package java8;

import java.util.Scanner;

//사과(KOI 2015 초등부)
public class Jungol2911 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int sum = 0;
		int a, b;
		for(int i = 0 ; i < N; i++){
			a = input.nextInt();
			b = input.nextInt();
			sum += b%a;
		}
		System.out.println(sum);
	}
}
