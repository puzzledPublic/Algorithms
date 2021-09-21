package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수들의 합
public class BJ1789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		solve(N);
	}
	//1부터 구해보면 최대 갯수가 1, 1, 2, 2, 2 ,3, 3, 3, 3, 4, 4, 4, 4 ,4...이런식이다.
	//그렇다면 N <= (i * (i + 1)) / 2 - 1를 만족하는 i를 알 수 있다. 여기서 i - 1이 최대 갯수
	static void solve(long n) {	
		long i = 2;
		while(true) {
			if(n <= (i * (i + 1)) / 2 - 1) {
				System.out.println(i - 1);
				break;
			}
			i++;
		}
	}
}
