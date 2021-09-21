package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//소수 단어
public class BJ2153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('A' <= ch && ch <= 'Z') {
				sum += ch - 'A' + 27;
			}else {
				sum += ch - 'a' + 1;
			}
		}
		
		bw.write(isPrime(sum) ? "It is a prime word." : "It is not a prime word.");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPrime(int num) {		
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
