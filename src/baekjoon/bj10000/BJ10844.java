package baekjoon.bj10000;

import java.util.Scanner;

//쉬운 계단 수
public class BJ10844 {
	static int N;
	static int M = 1000000000;
	static long[][] DT = new long[101][10];	//DT[i][j] = i번째 자리에 j번째 숫자가 왔을때 가능한 계단 수
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		solve();
	}
	static void solve() {
		for(int i = 1; i < 10; i++) {	//1번째 자리에 j번째 숫자가 오는 경우는 1가지뿐 (0으로 시작은 제외)
			DT[1][i] = 1;
		}
		for(int i = 2; i < N + 1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 9)  {
					DT[i][j] = DT[i - 1][j - 1] % M;	//9일때는 10으로 갈 수 없으므로
				}else if(j == 0) {
					DT[i][j] = DT[i - 1][j + 1] % M;	//0일때는 -1로 갈 수 없으므로
				}
				else {
					DT[i][j] = (DT[i - 1][j - 1] + DT[i - 1][j + 1]) % M;	
					//i - 1번째 자리에서 현재 j를 기준으로 1 작은 경우와 1 큰 경우를 합한 값이
					//현재 i번째 자리에 j번째 숫자가 왔을때 가능한 계단 수의 갯수
				}
			}
		}
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += DT[N][i];
		}
		System.out.println(result % M);
	}
}
