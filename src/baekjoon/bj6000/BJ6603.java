package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//로또
public class BJ6603 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			int[] arr = new int[N];
			boolean[] chk = new boolean[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(arr, chk, -1, 0, bw);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, boolean[] chk, int next, int n, Writer w) throws IOException {
		if(n == 6) {	//6개를 모두 골랐다면 출력
			for(int i = 0; i < chk.length; i++) {
				if(chk[i]) {
					w.write(arr[i] + " ");
				}
			}
			w.write("\n");
			return;
		}
		for(int i = next + 1; i < arr.length; i++) {	//숫자를 고른다
			if(!chk[i]) {	//고르지 않은 거라면
				chk[i] = true;	//골랐음을 체크
				solve(arr, chk, i, n + 1, w);
				chk[i] = false;	//백트래킹
			}
		}
	}
}
