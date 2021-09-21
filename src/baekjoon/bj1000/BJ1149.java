package baekjoon.bj1000;

import java.util.Scanner;

//RGB 거리
public class BJ1149 {
	static int N; //
	static int[][] arr;
	static int[][] DT;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N][3];
		DT = new int[N][3];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		solve();
	}
	//동적계획법
	static void solve() {
		for(int i = 0; i < 3; i++) {	//동적테이블 초기값 설정
			DT[0][i] = arr[0][i];
		}
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				DT[i][j] = Math.min(DT[i - 1][(j + 1) % 3], DT[i - 1][(j + 2) % 3]) + arr[i][j];	
				//f(i, j) = i번째 집을 j번째 색으로 칠했을때 지금까지 드는 최솟값
				//총 3가지 색이므로 i번째 집에서 j번째 색을 고른 경우, (i - 1)번째 집에서 (j + 1) % 3, (j + 2) % 3 번째 색을 고른 경우 중에 작은 값을 고르면 된다.
			}
		}
		int result = 987654321;
		for(int i = 0; i < 3; i++) {
			result = Math.min(result, DT[N - 1][i]);
		}
		System.out.println(result);
	}
}
