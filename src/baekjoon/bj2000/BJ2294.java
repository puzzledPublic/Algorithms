package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//동전 2
public class BJ2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		int[][] dp = new int[K + 1][N];	//dp[i][j] = 0 ~ j의 동전을 사용해서 i원을 만들 수 있는 동전의 최소 갯수
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
//		Arrays.sort(coins);
		
		for(int i = 0; i < K + 1; i++) {	//배열 초기화
			Arrays.fill(dp[i], 987654321);
		}
		
		for(int i = 1; i < K + 1; i++) {	//각 동전으로 만들 수 있는 i원을 구해놓는다.
			for(int j = 0; j < N; j++) {
				if(i % coins[j] == 0) {
					dp[i][j] = i / coins[j];
				}
			}
		}
		for(int i = 1; i < K + 1; i++) {
			for(int j = 0; j < N; j++) {	//i - coins[j] >= 0일때
				if(i - coins[j] >= 0) {
					for(int k = 0; k <= j; k++) {	//dp[i][j] = Math.min(dp[i - coins[j]][0] ~ dp[i - coins[j]][j]) + 1
						dp[i][j] = Math.min(dp[i - coins[j]][k] + 1, dp[i][j]);
					}
				}
			}
		}
		
		int result = 987654321;
		for(int i = 0; i < N; i++) {
			result = Math.min(result, dp[K][i]);
		}
		if(result == 987654321) {
			bw.write("-1\n");
		}else{
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
