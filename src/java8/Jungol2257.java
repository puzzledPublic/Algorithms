package java8;

import java.util.Scanner;

//검증수 (KOI 본선 2010 초등부)
public class Jungol2257 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int powSum = 0;
		int t;
		for(int i = 0 ; i < 5; i++){
			t = input.nextInt();
			powSum += t*t;
		}
		System.out.println(powSum%10);
	}
}
