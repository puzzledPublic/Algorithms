package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이항 계수 1
public class BJ11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		bw.write(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
		
		bw.close();
		bw.close();
		br.close();
	}
	
	static int solve(int n, int k) {
		if(k == 1) {
			return n;
		}
		if(k == 0) {
			return 1;
		}
		if(n == k) {
			return 1;
		}
		return solve(n - 1, k - 1) + solve(n - 1, k);
	}
}
