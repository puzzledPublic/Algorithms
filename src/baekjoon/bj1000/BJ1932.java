package baekjoon.bj1000;

import java.util.Scanner;
//정수 삼각형
public class BJ1932 {
	static int N;
	static int[][] arr, DT; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N][N];
		DT = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		solve();
	}
	
	static void solve() {
		DT[0][0] = arr[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				if(j == 0) {	//i, j >= 0
					DT[i][j] = DT[i - 1][j] + arr[i][j];
				}else {
					DT[i][j] = Math.max(DT[i - 1][j - 1], DT[i - 1][j]) + arr[i][j];	
					//f(i, j) = i번째 층 j번째 위치에서의 최대값
					//맨 꼭대기가 f(0, 0)으로 시작할때, 삼각형이고 왼쪽 아래, 오른쪽 아래만 선택 가능하므로 
					//i번째 층 j번째 위치에서는 i - 1번째 층에서 j - 1번째 또는 j번째 중 최대값을 고르면 현재 위치의 최대값을 구할 수 있다.
				}
			}
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, DT[N - 1][i]);
		}
		System.out.println(result);
	}
}
