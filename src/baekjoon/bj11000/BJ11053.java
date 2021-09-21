package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 순열
public class BJ11053 {
	static int N;
	static int[] dp, seq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {	//모든 위치에서 시도해본다.
			result = Math.max(result, solve(i));
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//dp[i]는 i번째부터 시작하는 최대 증가 부분순열의 길이
	//메모이제이션
	static int solve(int start) {
		if(dp[start] != 0) {	//계산이 이미 돼있다면 바로 값 리턴
			return dp[start];
		}
		int result = 1;	//뒤의 증가되는 수가 없다면 기본적으로 증가 부분순열 길이는 1
		for(int i = start + 1; i < N; i++) {	//start 이후의 숫자들을 탐색
			if(seq[start] < seq[i]) {	//현재보다 더 크다면
				result = Math.max(result, solve(i) + 1);	//다음 수를 start로 두고 다시 탐색.
			}
		}
		return dp[start] = result;	//메모이제이션
	}
}
