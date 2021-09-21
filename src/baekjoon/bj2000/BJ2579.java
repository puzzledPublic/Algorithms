package baekjoon.bj2000;

import java.util.Scanner;
//계단 오르기
public class BJ2579 {
	static int N;
	static int[] arr;
	static int[] DT;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N + 3];	//N <= 3의 경우 outOfIndexException을 방지하기 위해 배열 크기 좀 더 늘림
		DT = new int[N + 3];
		for(int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		solve();
	}
	
	static void solve() {
		DT[0] = arr[0];
		DT[1] = arr[0] + arr[1];
		DT[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
		for(int i = 3; i < N; i++) {
			DT[i] = Math.max(arr[i - 1] + DT[i - 3], DT[i - 2]) + arr[i];
			//f(n) = n 계단까지 올라 왔을때 점수의 최대합
			//n 계단까지 올라올 수 있는 경우는 n - 1에서 올라오던가 n - 2에서 올라오던가 둘 중에 하나다.
			//그런데 계단을 연속하여 3번 올라갈 수 없으므로 n - 1에서 올라오는 경우는 f(n - 3)에서 arr[n - 1]과 arr[n]을 더한 값이다.
		}
		System.out.println(DT[N - 1]);
	}
}
