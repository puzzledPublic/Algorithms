package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다이얼
public class BJ5622 {
	static int[] alpha = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine());
	} 
	static void solve(String s) {
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			sum += alpha[s.charAt(i) - 65];
		}
		System.out.println(sum);
	}
}
