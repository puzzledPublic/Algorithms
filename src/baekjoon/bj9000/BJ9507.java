package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Generations of Tribbles
public class BJ9507 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] DP = new long[68];

		DP[0] = DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		for(int i = 4; i < 68; i++) {
			DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3] + DP[i - 4];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			bw.write(DP[input] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
