package java8;

import java.util.Scanner;

//타일 장식물(KOI 2016 초등부)
public class Jungol2992 {
	static long temp[] = new long[81];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N;
		N= input.nextInt();
		
		System.out.println(fib(N));
		input.close();
		
	}
	//피보나치 재귀(메모이제이션)
	private static long fib(int n){
		if(n == 1){
			return 4;
		}
		if(n == 2){
			return 6;
		}
		if(temp[n]!=0){
			return temp[n];
		}
		return temp[n] = fib(n-1)+fib(n-2);
	}
}
