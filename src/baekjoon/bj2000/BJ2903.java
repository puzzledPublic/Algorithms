package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//중앙 이동 알고리즘
public class BJ2903 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int result = solve(N);
		bw.write((result * result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//f(0) = 2;
	//f(n) = f(n - 1) * 2 - 1; (n > 0)
	static int solve(int n) {
		if(n == 0) {
			return 2;
		}
		return solve(n - 1) * 2 - 1;
	}
}
