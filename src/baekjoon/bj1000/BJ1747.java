package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//소수 & 팰린드롬
public class BJ1747 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		while(true) {
			if(isPalindrom(N) && isPrimeNumber(N)) {
				bw.write(N + "\n");
				break;
			}
			N++;
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPrimeNumber(int n) {
		if(n == 1) {
			return false;
		}
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalindrom(int n) {
		String str = String.valueOf(n);
		int s = 0, e = str.length() - 1;
		while(s < e) {
			if(str.charAt(s++) != str.charAt(e--)) {
				return false;
			}
		}
		return true;
	}
}
