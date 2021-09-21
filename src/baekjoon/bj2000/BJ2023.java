package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
//신기한 소수
public class BJ2023 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		solve(0, sb, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, StringBuilder sb, Writer w) throws IOException {
		if(n == N) {	//원하는 N자리가 됐으면 출력
			w.write(sb + "\n");
			return;
		}
		int i = (n == 0 ? 2 : 1);	//첫번째 자리에 1이 오면 안된다. 1은 소수가 아니므로
		for(; i < 10; i++) {
			sb.append(i);
			if(isPrime(Integer.parseInt(sb.toString()))) {	//n자리까지의 수가 소수인가? 그럼 더 이어보자
				solve(n + 1, sb, w);
			}
			sb.deleteCharAt(sb.length() - 1);	//백트래킹
		}
	}
	static boolean isPrime(int n) {	//소수 판별
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
