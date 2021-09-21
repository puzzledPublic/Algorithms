package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//모든 순열
public class BJ10974 {
	static int N;
	static int[] arr;
	static boolean[] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		chk = new boolean[N + 1];
		solve(0, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start, Writer w) throws IOException {
		if(start == N) {
			for(int i = 0; i < N; i++) {
				w.write(arr[i] + " ");
			}
			w.write("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				arr[start] = i;
				solve(start + 1, w);
				chk[i] = false;
			}
		}
	}
}
