package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//이항 계수 3	
//구하고자하는 이항계수 nCr에서 n, r이 너무 큰값이다. 
//nCr = n! / (n! * (n - r)!)이고 우리는 여기에 1000000007을 나눈 나머지 값을 원한다.
//나눈 나머지를 위해 n! * (n! * (n - r)!)^-1로 역원을 구할 수 있고 이 역원을 계산해야한다.
//이때 확장유클리드 알고리즘, 페르마의 소정리를 이용해 역원을 구할 수 있다. (https://www.acmicpc.net/blog/view/29 참조)
public class BJ11401 {
	static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		solve(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(long n, long k, Writer w) throws IOException {
		long ans = 1, t1 = 1, t2 = 1;
		for(long i = 1; i <= n; i++) {	//n!을 구한다.
			t1 *= i;
			t1 %= MOD;
		}
		for(long i = 1; i <= k; i++) {	//k!을 구한다.
			t2 *= i;
			t2 %= MOD;
		}
		for(long i = 1; i <= n - k; i++) {	//(n-k)!을 구한다.
			t2 *= i;
			t2 %= MOD;
		}
		long t3 = mul(t2, MOD - 2);	//(k! * (n-k)!)^(p-2)를 구한다. (페르마 소정리)
		t3 %= MOD;
		ans = t1 * t3;	//n!(k! * (n-k)!)^-1을 계산한다.
		ans %= MOD;
		w.write(ans + "\n");
	}
	static long mul(long x, long y) {	//O(logn) 거듭제곱 (분할정복, ex. 2^8일때 2^4*2^4이고 2^4는 다시 2^2*2^2가 된다)
		long ans = 1;
		while(y > 0) {
			if(y % 2 != 0) {
				ans *= x;
				ans %= MOD;
			}
			x *= x;
			x %= MOD;
			y /= 2;
		}
		return ans;
	}
}
