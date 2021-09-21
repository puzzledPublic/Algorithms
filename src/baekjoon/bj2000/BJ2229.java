package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//조짜기
public class BJ2229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] min = new int[N][N];	//arr[i]~arr[j]까지 최소값
		int[][] max = new int[N][N];	//arr[i]~arr[j]까지 최대값
		int[] dp = new int[N];	//dp[i] = i번째 사람까지 조를 짤 때 얻는 시너지 최대 값
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			Arrays.fill(max[i], Integer.MIN_VALUE);
			min[i][i] = max[i][i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 1; j < N; j++) {
			for(int i = 0; i < N - j; i++) {
				min[i][i + j] = Math.min(min[i][i + j - 1], arr[i + j]);
				max[i][i + j] = Math.max(max[i][i + j - 1], arr[i + j]);
			}
		}
		
		for(int i = 1; i < N; i++) {
			dp[i] = max[0][i] - min[0][i];
			for(int j = i - 1; j >= 0; j--) {	//dp[i] = dp[j] + (j+1~i까지 조를 이룰때 시너지 값)
				dp[i] = Math.max(dp[i], dp[j] + (max[j + 1][i] - min[j + 1][i]));
			}
		}
		
		bw.write(dp[N - 1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
