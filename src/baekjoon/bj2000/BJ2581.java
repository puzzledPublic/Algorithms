package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//소수
public class BJ2581 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		solve(N, M, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int m, Writer w) throws IOException {
		boolean[] arr = new boolean[m + 1];
		arr[1] = true;
		for(int i = 2; i * i <= m; i++) {
			if(!arr[i]) {
				for(int j = i * 2; j <= m; j += i) {
					arr[j] = true;
				}
			}
		}
		int sum = 0, min = 0;
		for(int i = m; i >= n; i--) {
			if(!arr[i]) {
				sum += i;
				min = i;
			}
		}
		if(sum != 0) {
			w.write(sum + "\n");
			w.write(min + "\n");
		}else {
			w.write(-1 + "\n");
		}
	}
}
