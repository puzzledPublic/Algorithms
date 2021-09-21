package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분수 찾기
public class BJ1193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solve(N);
	}
	static void solve(int n) {
		int i = 1;
		while(true) {	//i*(i-1)/2 < N <= i*(i+1)/2이다. 이때 i는 해당 N번째 분수가 속한 구간(그 구간의 분수 갯수도 i개)에서 시작하는 분수의 분모 분자 중 최대 값이 된다.
			if((i * (i + 1)) / 2 >= n) {
				break;
			}
			i++;
		}
		int k = (i * (i + 1)) / 2 - n, t = i, b = 1;
		while(k > 0) {
			t -= 1;
			b += 1;
			k--;
		}
		System.out.println(i % 2 == 0 ? t + "/" + b : b + "/" + t);	//i가 짝수, 홀수냐에 따라 분모 분자가 바뀐다.
	}
}
