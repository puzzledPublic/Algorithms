package java8;

import java.util.Scanner;

//과자 2014 KOI 초등부
public class Jungol2750 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int K, N, M;
		K = input.nextInt(); //과자 한 개의 가격
		N = input.nextInt(); //사려고 하는 과자 개수
		M = input.nextInt(); //가진 돈
		
		if(K * N > M){
			System.out.println((K * N) - M);
		}
		else{
			System.out.println("0");
		}
	}
}
