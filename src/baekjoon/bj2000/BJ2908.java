package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//상수
public class BJ2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = solve(Integer.parseInt(st.nextToken())),  b = solve(Integer.parseInt(st.nextToken()));
		System.out.println(a > b? a : b);
	}
	static int solve(int n) {	//재귀로 숫자 뒤집기
		if(n < 10) {
			return n;
		}
		int p = (int) Math.pow(10, (int)Math.log10(n));
		return p * (n % 10) + solve((n - ((n / p) * p)) / 10) * 10 + n / p;
	}
}
