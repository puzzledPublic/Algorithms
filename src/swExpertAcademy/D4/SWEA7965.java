package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//퀴즈
public class SWEA7965 {
	static long Mod = 1000000007;
//	static long ppow(long a, long b) {
//		if(b == 0) {
//			return 1;
//		}
//		long n = ppow(a, b / 2);
//		if(b % 2 == 0) {
//			return (n * n) % Mod;
//		}else {
//			return ((a % Mod) * ((n * n) % Mod)) % Mod;
//		}
//	}
	static long ppow(long a, long b) {	//분할정복으로 빠른 거듭제곱
		long res = 1;
		while(b > 0) {
			if((b & 1) == 1) {
				res = (res * a) % Mod;
			}
			b >>= 1;
			a = (a * a) % Mod;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		long[] cache = new long[1000001];
		for(int i = 1; i < cache.length; i++) {	//(i^i) % Mod를 캐싱한다.
			cache[i] = ppow(i, i);
		}
		for(int t = 1; t <= T; t++) {
			long n = Long.parseLong(br.readLine());
			long s = 0;
			
			for(int i = 1; i <= n; i++) {	//sum(1^1, 2^2, 3^3 ... , i^i) % Mod
				s = (s + cache[i]) % Mod;
			}
		
			bw.write("#" + t + " " + s + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
