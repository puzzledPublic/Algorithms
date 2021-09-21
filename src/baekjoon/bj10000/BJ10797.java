package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10부제
public class BJ10797 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(arr, n);
	}
	static void solve(int[] arr, int n) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(arr[i] == n) {
				count++;
			}
		}
		System.out.println(count);
	}
}
