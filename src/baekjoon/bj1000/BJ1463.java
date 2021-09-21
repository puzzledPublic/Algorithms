package baekjoon.bj1000;

import java.util.Scanner;

//1로 만들기
public class BJ1463 {
	static int N;
	static int[] DT;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		DT = new int[N + 4];
		DT[2] = DT[3] = 1;
		
		//System.out.println(solve(N));
		solve2();
		//solve3();
	}
	//메모이제이션
	static int solve(int n) {
		if(n <= 3) {
			return DT[n];
		}
		if(DT[n] == 0) {
			int result = 987654321;
			if(n % 3 == 0) {
				result = Math.min(result, solve(n / 3));
			}
			if(n % 2 == 0) {
				result = Math.min(result, solve(n / 2));
			}
			DT[n] = Math.min(result, solve(n - 1)) + 1;
		}
		return DT[n];
	}
	//동적계획법
	static void solve2() {
		for(int i = 4; i <= N; i++) {
			int temp = 987654321;
			if(i % 3 == 0) {
				temp = Math.min(temp, DT[i / 3]);
			}
			if(i % 2 == 0) {
				temp = Math.min(temp, DT[i / 2]);
			}
			DT[i] = Math.min(temp, DT[i - 1]) + 1;
		}
		System.out.println(DT[N]);
	}
	//좀 더 간결하게
	static void solve3() {
		for(int i = 2; i <= N; i++) {
			DT[i] = DT[i - 1] + 1;
			if(i % 2 == 0 && DT[i] > DT[i / 2] + 1) {
				DT[i] = DT[i / 2] + 1;
			}
			if(i % 3 == 0 && DT[i] > DT[i / 3] + 1) {
				DT[i] = DT[i / 3] + 1;
			}
		}
		System.out.println(DT[N]);
	}
}
