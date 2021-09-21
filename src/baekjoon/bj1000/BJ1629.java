package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//곱셈
public class BJ1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());
		solve(a, b, c);
	}
	//거듭제곱 분할정복
	static void solve(long a, long b, long c) {
		long temp = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				temp *= a;
				temp %= c;
			}
			a *= a;
			a %= c;
			b /= 2;
		}
		System.out.println(temp);
	}
}
