package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 이어쓰기 1
public class BJ1748 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		bw.write(solve(N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int n) {
		int count = (int)Math.log10(n), k = 9, result = 0;	//count = 주어진 수의 자리수, k = 1자리 수의 개수
		for(int i = 1; i < count + 1; i++) {	//1자리 수 9개, 2자리수 90개, 3자리수 900개..., count - 1 자리수 아래 수들의 자리수들을 합산
			result += (k * i);
			k *= 10;
		}
		int t = n - (int)Math.pow(10, count) + 1;	//n의 자리수(count)들의 개수
		result += (t * (count + 1));
		return result;
	}
	//다른 풀이
	static int solve2(int n) {
		int result = 0;
		for(int i = 1 ; i <= n ; i *= 10) {	//1~n까지 자연수들이 있을때 1자리가 있는 수들의 개수는 n개, 2자리가 있는 수들의 개수는 n - 10 + 1개, 3자리가 있는 수들의 개수는 n - 100 + 1개...
			result += n - i + 1;
		}
		return result;
	}
}
