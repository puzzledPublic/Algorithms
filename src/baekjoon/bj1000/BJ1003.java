package baekjoon.bj1000;

import java.util.Scanner;

//피보나치 함수
public class BJ1003 {
	static int N; //0 <= N <= 40
	static int[] arr;
	static int[][] DT = new int[41][2];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		solve();
	}
	//동적계획법
	static void solve() {
		DT[0][0] = DT[1][1] = 1;		
		DT[0][1] = DT[1][0] = 0;
		for(int i = 2; i < 41; i++) {	//f(n, i) = f(n - 1, i) + f(n - 2, i) -> n일때 i를 출력하는 횟수
			DT[i][0] = DT[i - 1][0] + DT[i - 2][0]; 
			DT[i][1] = DT[i - 1][1] + DT[i - 2][1];
		}
		for(int i = 0; i < N; i++) {
			System.out.println(DT[arr[i]][0] + " " + DT[arr[i]][1]);
		}
	}
}
