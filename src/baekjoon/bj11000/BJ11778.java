package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//피보나치 수와 최대공약수
public class BJ11778 {
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		solve(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	//gcd(fib(n),fib(m))을 구하는 문제. gcd(fib(n), fib(m)) = fib(gcd(n, m))으로 푸는 문제. 
	static void solve(long n, long m, Writer w) throws IOException {
		long c = n < m ? gcd(m, n) : gcd(n, m);
		long d = getFib(c);
		w.write(d + "\n");
	}
	static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	//피보나치 숫자가 크므로 행렬 곱셈을 통해 구한다.
	static long getFib(long n) {
		long[][] ans = {{1, 0}, {0, 1}}, fib = {{1, 1}, {1, 0}};
		while(n > 0) {
			if(n % 2 == 1) {
				ans = matMul(ans, fib);
			}
			fib = matMul(fib, fib);
			n /= 2;
		}
		return ans[0][1];
	}
	static long[][] matMul(long[][] a, long[][] b) {
		long[][] temp = new long[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					temp[i][j] += a[i][k] * b[k][j];
				}
				temp[i][j] %= MOD;
			}
		}
		return temp;
	}
}
