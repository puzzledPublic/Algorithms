package java8;

import java.util.Scanner;

//도미노
public class Jungol1039 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n;
		n = input.nextInt();
		n++;
		int result = 0;
		result = n*(n+1)/2;
		System.out.println(result);
	}
	
}
