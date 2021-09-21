package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//N과 M(10)
public class BJ15664 {
	static int[] nums;
	static int[] pick;
	static boolean[] chk;
	static Set<String> set = new HashSet<>();	//중복 검사를 위한 set
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		chk = new boolean[N];
		pick = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		solve(0, 0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int k, Writer bw) throws IOException {	//n번째 숫자, k = 오름차순을 위한 인덱스 저장.
		if(n == M) {
			String tmp = "";
			for(int i = 0; i < M - 1; i++) {
				tmp += (pick[i] + " ");
			}
			tmp += pick[M - 1];
			if(set.contains(tmp)) {	//이미 출력된 상태(set에 이미 저장됨)면 바로 리턴.
				return;
			}
			set.add(tmp);	//아니라면 저장한 후 출력.
			bw.write(tmp + "\n");
			return;
		}
		
		for(int i = k; i < N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				pick[n] = nums[i];
				solve(n + 1, i + 1, bw);
				chk[i] = false;
			}
		}
	}
}
