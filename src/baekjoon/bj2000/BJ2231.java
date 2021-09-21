package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분해합
public class BJ2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solve(N);
	}
	//어떤 분해합 N이 주어졌을때 생성자를 구하는 문제
	//생성자를 M이라고 두면 N = M + for(k = 0 ~ log10(M)) { sum += (M / 10^k) % 10 }으로 나타낼 수 있다.
	//이를 모든 M에 대해 탐색해보면 되는데 탐색할 범위를 생각해보면
	//현재 입력 자연수의 범위가 1 <= N <= 1,000,000이다
	//M이 N이상일 수 없으므로 최대치가 N이다. 모든 자리수를 더했을때 최대 값은 54이다(999,999인 경우), 최소치는 n - 54이다.
	//그러므로 n - 54 <= M <= N인 경우에 대해 탐색해보면 된다.
	static void solve(int n) {
		int s = 0;
		int start = n - 54 <= 0 ? 1 : n - 54;	//n < 55인 경우 1부터 시작
		int end = n;
		boolean flag = false;
		for(int i = start; i < end; i++) {
			s = i;
			for(int j = 0; j <= Math.log10(i); j++) {
				s += (i / (int)Math.pow(10, j)) % 10;
			}
			if(s == n) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		if(!flag) {
			System.out.println(0);
		}
	}
}
