package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GCD(a,b) = 1	어떤 자연수 a와 서로소인 b (1 <= b <= a) (오일러 파이(φ) 함수)  
public class BJ11689 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		if(N == 1) {
			System.out.println(1);
		}else {
			solve(N);
		}
	}
	//φ(a) = a^m - a^(m-1) (a는 소수)	//φ(a) = a와 서로소인 자연수의 갯수 (1 <= x <= a)
	//φ(a*b) = φ(a) * φ(b)	//어떤 x를 소인수 분해하여 소수의 제곱의 곱들로 나타낼 수 있다.
	static void solve(long n) {
		long limit = (int)Math.sqrt(n);
		long result = 1, temp = 1;
		for(long i = 2; i <= limit; i++) {	//소인수분해
			boolean flag = false;
			if(n <= 0) {
				break;
			}else {
				while(n % i == 0) {	
					flag = true;
					temp *= i;	//a^m
					n /= i;
				}
				limit = (int)Math.sqrt(n);
			}
			if(flag) {
			temp = temp - (temp / i);	//φ(a) = a^m - a^(m-1)
			result *= temp;	//φ(a*b*...)
			temp = 1;
			flag = false;
			}
		}
		if(n > 1) {
			result *= (n - 1);
		}
		System.out.println(result);
	}
}
