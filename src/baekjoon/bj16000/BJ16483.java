package baekjoon.bj16000;

import java.util.Scanner;

//접시 안의 원
public class BJ16483 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt(); 
		//a^2 = b^2 + (T/2)^2
		//a^2 - b^2 = (T/2)^2
		System.out.println(Math.round((double)(T * T) / 4));
	}
}
