package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//거스름 돈(그리디)
public class BJ5585 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solve(N);
	}
	//거스름 돈 갯수를 최소화 하기 위해 최대한 숫자가 높은 동전부터 채운다.
	static void solve(int n) {
		n = 1000 - n;
		int[] coins = {500, 100, 50, 10, 5, 1};
		int count = 0;
		for(int i = 0; i < coins.length; i++) {
			if(n >= coins[i]) {
				count += n / coins[i];
				n %= coins[i];
			}
		}
		System.out.println(count);
	}
}
