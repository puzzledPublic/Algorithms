package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//비요뜨의 징검다리 건너기
public class BJ18291 {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			bw.write((n == 1 ? "1\n" : pow(n - 2) + "\n"));
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static long pow(int k) {	//거듭 제곱 분할정복
		if (k == 0) {
			return 1;
		}
		if (k == 1) {
			return 2;
		}
		if (k % 2 == 0) {
			long p = pow(k / 2);
			return (p * p) % MOD;
		}
		return (2 * pow(k - 1)) % MOD;
	}
}
