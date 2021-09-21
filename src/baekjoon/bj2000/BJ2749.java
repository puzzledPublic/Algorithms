package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//피보나치 수 3	(피사노 주기 Pisano Period) 
//피보나치 수를 K로 나눈 나머지는 항상 주기를 가지게 됩니다
//주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같습니다.
//M = 10^k일때 k>2이면 주기는 항상 15*10^(k-1)
public class BJ2749 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());
		int mod = 1000000; //10^6
		int p = mod / 10 * 15; //15 * 10^(6-1);
		int[] DP = new int[p];
		DP[0] = 0;
		DP[1] = 1;
		for(int i = 2; i < p; i++) {
			DP[i] = DP[i - 1] + DP[i - 2];
			DP[i] %= mod;
		}
		bw.write(DP[(int) (n % p)] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
