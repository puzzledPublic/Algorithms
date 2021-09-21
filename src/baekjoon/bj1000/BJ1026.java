package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//보물
public class BJ1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n], b = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " "), st2 = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}
		solve(a, b, n);
	}
	
	static void solve(int[] a, int[] b, int n) {
		Arrays.sort(a);
		Arrays.sort(b);
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += (a[i] * b[n - i - 1]);
		}
		System.out.println(sum);
	}
}
