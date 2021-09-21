package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//피보나치 수 2
public class BJ2748 {
	static long[] DP = new long[91];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		DP[0] = 0;
		DP[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			DP[i] = DP[i - 1] + DP[i - 2];
		}
		bw.write(DP[n] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
