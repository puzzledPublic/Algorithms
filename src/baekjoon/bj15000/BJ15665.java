package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (11)
public class BJ15665 {
	static int[] nums;
	static int[] pick;
	static int N, M;
	static boolean[] chk;
	static int count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		pick = new int[M];
		chk = new boolean[10001];
		Arrays.fill(nums, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!chk[num]) {	//중복되는 숫자가 없도록 나열.
				chk[num] = true;
				nums[count++] = num;
			}
		}
		
		Arrays.sort(nums);
		
		solve(0);
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n) throws IOException {
		if(n == M) {
			for(int i = 0; i < M - 1; i++) {
				sb.append(pick[i]).append(' ');
			}
			sb.append(pick[M - 1]).append('\n');
			return;
		}
		
		for(int i = 0; i < count; i++) {
			pick[n] = nums[i];
			solve(n + 1);
		}
	}
}
