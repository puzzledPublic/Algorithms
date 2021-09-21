package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//에라토스테네스의 체
public class BJ2960 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		solve(n, k);
	}
	static void solve(int n, int k) {
		boolean[] arr = new boolean[n + 1];
		int count = 0;
		for(int i = 2; i <= n; i++) {
			for(int j = i; j <= n; j += i) {
				if(!arr[j]) {
					arr[j] = true;
					count++;
					if(count == k) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}
}
