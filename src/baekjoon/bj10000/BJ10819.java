package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//차이를 최대로
public class BJ10819 {
	static int N, max;
	static int[] arr;
	static int[] order;
	static boolean[] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		order = new int[N];
		chk = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//모든 순열을 찾고 그에따라 계산한 후 가장 큰 값을 찾는다.
	static void solve(int start) {
		if(start == N) {
			int t = 0;
			for(int i = 1; i < order.length; i++) {
				t += Math.abs(arr[order[i - 1]] - arr[order[i]]);
			}
			if(max < t) {
				max = t;
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				order[start] = i;
				solve(start + 1);
				chk[i] = false;
			}
		}
	}
}
