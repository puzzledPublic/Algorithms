package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//N과 M (12)
public class BJ15666 {
	static int[] nums;
	static int[] pick;
	static Set<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	static int N, M, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		pick = new int[M];
		
		Arrays.fill(nums, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(set.contains(k)) continue;	//중복되는 숫자 제거
			set.add(k);
			nums[count++] = k;
		}
		
		Arrays.sort(nums);	//오름차순 정렬.
		solve(0, 0);
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void solve(int n, int s) {	//n개 중 m개를 뽑아 나열할때(숫자 중복가능) 오름차순이 되는 수열을 만든다.
		if(n == M) {
			for(int i = 0; i < M - 1; i++) {
				sb.append(pick[i]).append(' ');
			}
			sb.append(pick[M - 1]).append('\n');
			return;
		}
		
		for(int i = s; i < count; i++) {
			pick[n] = nums[i];
			solve(n + 1, i);
		}
	}
}
