package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//완전 제곱수
public class BJ1977 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine());
		solve(m, n, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int m, int n, Writer w) throws IOException {
		int sum = 0, last = 0, nn = (int)Math.sqrt(n), mm = (int)Math.ceil(Math.sqrt(m));
		for(int i = nn; i >= mm; i--) {
			sum += (i * i);
			last = i;
		}
		if(sum != 0) {
			w.write(sum + "\n");
			w.write((last * last) + "\n");
		}else {
			w.write(-1 + "\n");
		}
	}
}
