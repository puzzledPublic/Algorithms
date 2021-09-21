package java8;

import java.util.Scanner;

//하노이의 탑
public class Jungol1161 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N;
		N = input.nextInt();
		hanoi(N, 1, 2, 3);
	}
	
	static void hanoi(int n, int from, int middle, int to){
		if(n == 1){
			System.out.println(n + " : " + from + " -> " + to);
			return;
		}
		hanoi(n - 1 , from, to, middle);
		System.out.println(n + " : " + from + " -> " + to);
		hanoi(n - 1, middle, from, to);
	}
}
