package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//N과 M(3)
public class BJ15651 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] ans = new int[N];
		
		solve(ans, 0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] ans, int m, Writer w) throws IOException {
		if(m == M) {
			for(int i = 0; i < M; i++) {
				w.write(ans[i] + " ");
			}
			w.write('\n');
			return;
		}
		
		for(int i = 1; i < N + 1; i++) {
			ans[m] = i;
			solve(ans, m + 1, w);
		}
	}
}
