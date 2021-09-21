package baekjoon.bj1000;

import java.util.Scanner;
//수열의 합
//숫자 n으로 시작하는 수열이라하면
//n, n + 1, n + 2 ... n + 100 (최대 100개 수열이므로)이 될수 있고
//수열의 합을 일반화하면 k * n + k * (k - 1) / 2 = N이 된다. (k는 수열의 개수, n은 수열의 첫번째 숫자, N은 수열의 합)
//n에 대해 풀면 n = (2 * N + i - i * i) / (2 * i)이 된다.
//이를 k(입력 L)를 증감시키면서 만족시키는 정수 n이 존재하면 L 이상인 최소개의 수열을 구할 수 있다.
public class BJ1024 {
	static int N, L;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		L = input.nextInt();
		solve();
	}
	static void solve() {
		for(int i = L; i <= 100; i++) {
			if((2 * N + i - i * i) % (2 * i) == 0) {	
				int n = (2 * N + i - i * i) / (2 * i);
				if(n >= 0) {
					for(int k = n; k < n + i; k++) {
						System.out.print(k + " ");
					}
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
