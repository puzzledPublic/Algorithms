package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//분산처리
public class BJ1009 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//거듭 제곱 분할정복
	static void solve(int a, int b, Writer w) throws IOException {
		int result = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				result *= a;
				result %= 10;
			}
			a *= a;
			a %= 10;
			b /= 2;
		}
		if(result == 0) {
			w.write("10\n");
		}else {
			w.write(result + "\n");
		}
	}
}
