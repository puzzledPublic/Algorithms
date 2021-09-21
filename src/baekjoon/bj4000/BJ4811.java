package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//알약
public class BJ4811 {
	static long[][] dp = new long[31][31];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		solve(0, 30);
		
		int N;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			bw.write(dp[0][N] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//solve(half, one) = solve(half - 1, one) + solve(half + 1, one - 1) (half - 1> 0, one - 1 > 0), solve(0, 0) = 1 
	static long solve(int half, int one) {	//절반 알약이 half개, 온전한 알약이 one개 있을때 만들 수 있는 문자열의 수
		if(half == 0 && one == 0) {	//다 먹은 경우 한가지 경우.
			return 1;
		}
		if(dp[half][one] != 0) {
			return dp[half][one];
		}
		if(one > 0) {
			dp[half][one] += solve(half + 1, one - 1);	//온전한 알약을 먹거나(온전한 알약을 먹었으면 절반 알약이 하나 늘어난다)
		}
		if(half > 0) {
			dp[half][one] += solve(half - 1, one);	//절반 알약을 먹거나
		}
		
		return dp[half][one];
	}
}
