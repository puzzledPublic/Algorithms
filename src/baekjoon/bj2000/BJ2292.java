package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//벌집
public class BJ2292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solve(N);
	}
	//N은 3*i*(i-1)+2 <= N <= 3*i*(i+1)+1 사이에 존재한다.
	static void solve(int n) {
		int i = 1;
		while(true) {
			if(3 * i * (i - 1) + 2 > n) {
				break;
			}
			i++;
		}
		System.out.println(i);
	}
}
