package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수의 확장
public class BJ1788 {
	static int DIV = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solve(N);
	}
	static void solve(int n) {
		int abs = Math.abs(n);
		int[] DP = new int[abs + 1];
		if(abs != 0) {
			DP[1] = 1;
		}
		for(int i = 2; i < DP.length; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2]) % DIV;
		}
		if(DP[abs] == 0) {
			System.out.println("0\n0");
		}
		else if(n < 0 && abs % 2 == 0) {	//n < 0인 경우 n > 0일때 피보나치 수와 같으나 |n|이 짝수일때 -f(n) 이다. 
			System.out.println("-1\n" + DP[abs]);
		}else {
			System.out.println("1\n" + DP[abs]);
		}
	}
}
