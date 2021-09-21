package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//소수 구하기
public class BJ1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		solve(M, N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int m, int n, Writer w) throws IOException {
		boolean[] arr = new boolean[n + 1];
		arr[1] = true;
		for(int i = 2; i * i <= n; i++) {
			if(!arr[i]) {
				for(int j = i * 2; j <= n; j += i) {
					arr[j] = true;
				}
			}
		}
		for(int i = m; i <= n; i++) {
			if(!arr[i]) {
				w.write(i + "\n");
			}
		}
	}
}
