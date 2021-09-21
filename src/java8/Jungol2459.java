package java8;

import java.util.Scanner;

//지능형 기차(KOI 2011 초등부)
public class Jungol2459 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int max = -1;
		int cus = 0;
		for(int i = 0 ; i < 4 ; i++){
			cus -= input.nextInt();
			cus += input.nextInt();
			max = Math.max(max, cus);
		}
		System.out.println(max);
	}
}
