package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//부분순열의 합
public class BJ14225 {
	static int[] arr;
	static int N;
	static boolean[] chk = new boolean[2_000_001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		
		for(int i = 1; i < chk.length; i++) {
			if(!chk[i]) {
				bw.write(i + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void solve(int n, int k) {
		if(n == N) {
			chk[k] = true;
			return;
		}
		
		solve(n + 1, k + arr[n]);	//고르거나
		solve(n + 1, k);	//고르지 않거나
	}
}