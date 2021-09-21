package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//팩토리얼
public class BJ7489 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			bw.write(solve(Integer.parseInt(br.readLine())) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve(int N) {
		int result = 1;
		for(int i = 2; i < N + 1; i++) {
			result *= i;
			while(result % 10 == 0) {	//뒤에 붙는 0 제거
				result /= 10;
			}
			result %= 100000;
		}
		return result % 10;
	}
}
