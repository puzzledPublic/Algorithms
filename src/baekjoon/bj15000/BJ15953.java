package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//상금 헌터
public class BJ15953 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			bw.write(solve(a, b) + "\n");
		}
		bw.flush();
		bw.close();
		bw.close();
	}
	static int solve(int a, int b) {
		int result = 0;
		if(0 < a && a <= 21) {
			if(a == 1) {
				result += 5000000;
			}else if(2 <= a && a <= 3) {
				result += 3000000;
			}else if(4 <= a && a <= 6) {
				result += 2000000;
			}else if(7 <= a && a <= 10) {
				result += 500000;
			}else if(11 <= a && a <= 15) {
				result += 300000;
			}else {
				result += 100000;
			}
		}
		if(0 < b && b <= 31) {
			if(b == 1) {
				result += 5120000;
			}else if(2 <= b && b <= 3) {
				result += 2560000;
			}else if(4 <= b && b <= 7) {
				result += 1280000;
			}else if(8 <= b && b <= 15) {
				result += 640000;
			}else {
				result += 320000;
			}
		}
		return result;
	}
}
