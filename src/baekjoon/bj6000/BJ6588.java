package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//골드바흐의 추측 (4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.)
public class BJ6588 {
	static boolean[] primeCheck = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//에라토스테네스 체
		primeCheck[1] = true;
		for(int i = 2; i * i <= 1000000; i++) {
			if(!primeCheck[i]) {
				for(int j = i + i; j <= 1000000; j += i) {
					primeCheck[j] = true;
				}
			}
		}
		
		int n, e;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			e = n - 1;	//n - 1부터 아래로 훑으며
			while(e > 2) {
				if(!primeCheck[n - e] && !primeCheck[e]) {	//두 숫자의 합이 n이고 두 숫자가 모두 소수이면 출력
					bw.write(n + " = " + (n - e) + " + " + e + "\n");
					break;
				}
				e--;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
