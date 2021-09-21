package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//합분해
public class BJ2225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		int mod = 1000000000;
		int[][] dp = new int[K + 1][N + 1];		//dp[i][j] = j 이하의 정수를 i개 골라 합했을때 j가 되는 경우의 수
		
		for(int i = 0 ; i < N + 1; i++) {	//1개만 고를때는 j밖에 없으므로 경우의 수는 1개
			dp[1][i] = 1;
		}
		///////아래 주석된 코드가 만드는 dp표를 보고 더 빠르게 만든 점화식
		for(int i = 0; i < K + 1; i++) {	//j가 0일때는 i개를 골라도 0...0이므로 경우의 수는 1개
			dp[i][0] = 1;
		}
		for(int i = 2; i < K + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		///////
		
		//i - 1개를 골랐을떄 j가 되는 경우의 수는 dp[i-1][j-k](k는 0~j)까지의 합이 된다.
		//dp[i][j] = for(k = 0~N) { sum(dp[i - 1][j - k]) }
//	  	for(int i = 2; i < K + 1; i++) {
//			for(int j = 0; j < N + 1; j++) {
//				for(int k = 0; k <= j; k++) {
//					dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
//				}
//			}
//		}
	  	
		bw.write(dp[K][N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
