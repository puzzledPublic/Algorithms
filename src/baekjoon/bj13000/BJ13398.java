package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//연속합 2
public class BJ13398 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		int[][] dp = new int[N][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		//dp[i][j] = i번째까지 번호를 지우지 않았을때(j==0), 지웠을때(j==1) 최대 연속합
		int max = nums[0];
		dp[0][0] = nums[0];
		dp[0][1] = 0;
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);	//번호를 지우지 않은 경우 = max(이전까지의 최대연속합 + 현재 번호, 현재 번호)
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);	//번호를 지우는 경우 = max(현재 번호를 지우고 이전까지의 최대연속합, 이미 지워진 상황에서 이전까지의 최대연속합 + 현재 번호)
		
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
