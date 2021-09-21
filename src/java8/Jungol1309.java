package java8;

import java.util.Scanner;

//ÆÑÅä¸®¾ó

public class Jungol1309 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		System.out.println(factorial(n));
	}
	static long factorial(int n){
		if(n <= 1){
			System.out.println(n+"! = " + n);
			return 1;
		}
		System.out.println(n+"! = " + n + " * " + (n-1) +"!");
		return n * factorial(n-1);
	}
}
