package baekjoon.bj2000;

import java.util.Scanner;
//숫자의 개수
public class BJ2577 {
	static int N = 1;
	static int[] arr = new int[10];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			N *= input.nextInt();
		}
		while(N > 0) {
			arr[N % 10]++;
			N /= 10;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
