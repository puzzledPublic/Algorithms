package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//별찍기 17
public class BJ10992 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		solve(N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, Writer w) throws IOException {
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				w.write(" ");
			}
			for(int j = 0; j < 2 * i + 1; j++) {
				if(j == 0 || j == 2 * i) {
					w.write("*");
				}else {
					w.write(" ");
				}
			}
			w.write("\n");
		}
		for(int i = 0; i < 2 * n - 1; i++) {
			w.write("*");
		}
		w.write("\n");
	}
}
