package java8;

import java.util.Scanner;

//Sumsets2 
public class Jungol1093 {
	static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T;
		T = input.nextInt();
		
		for(int i = 0 ; i < T; i++){
			count = 0;
			solve(input.nextInt(), 0);
			System.out.println(count);
		}
		
	}
	
	static void solve(int n, int k){
		if(n == 0){
			count++;
			return;
		}
		if(n < 0){
			return;
		}
		for(int i = k ; i < (int)(Math.log(n)/Math.log(2)) + 1; i++){
			solve(n - (int)Math.pow(2, i), i);
		}
	}
}
