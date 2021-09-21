package baekjoon.bj9000;

import java.util.Scanner;
//시험 성적
public class BJ9498 {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		solve(N);
	}
	static void solve(int n) {
		if(n >= 90) {
			System.out.println("A");
		}else if(n >= 80) {
			System.out.println("B");
		}else if(n >= 70) {
			System.out.println("C");
		}else if(n >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
