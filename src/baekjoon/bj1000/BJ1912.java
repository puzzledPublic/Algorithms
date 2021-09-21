package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연속합
public class BJ1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(Integer.parseInt(br.readLine()), br.readLine());
	}
	
	static void solve(int n, String s) {
		StringTokenizer st = new StringTokenizer(s, " ");
		int[] DP = new int[n + 1], num = new int[n + 1];	//DP[i] = i번째까지 선택했을때 최대 연속 합
		for(int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			if(DP[i - 1] + num[i] > num[i]) {	//현재값과 전까지의 연속합을 합했을때 더 높아지면
				DP[i] = DP[i - 1] + num[i];		//합을 계산
			}else {
				DP[i] = num[i];					//더 낮아지면 자기 자신을 둬서 다음 연속합을 만든다.
			}
		}
		int max = DP[1];
		for(int i = 2; i <= n; i++) {	//모든 연속합에 대해 제일 큰 값을 찾는다.
			if(max < DP[i]) {
				max = DP[i];
			}
		}
		System.out.println(max);
	}
}
