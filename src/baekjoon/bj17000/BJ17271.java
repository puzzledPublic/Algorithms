package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//리그 오브 레전설 (Small)
public class BJ17271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			if(i - M >= 0) {
				dp[i] = (dp[i - 1] + dp[i - M]) % 1000000007;
			}else {
				dp[i] += dp[i - 1] % 1000000007;
			}
		}
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
