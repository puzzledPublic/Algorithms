package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//파도반 수열	1,1,1,2,2,3,4,5,7,9,12
public class BJ9461 {
	static long[] DP = new long[101];	//수열이 int 값을 넘어가므로 long
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		DP[1] = DP[2] = DP[3] = 1;
		DP[4] = DP[5] = 2;
		for(int i = 6; i < DP.length; i++) {
			DP[i] = DP[i - 3] + DP[i - 4] + DP[i - 5];	//규칙을 찾아보면 dp[i] = dp[i-3] + dp[i-4] + dp[i-5]임을 알 수 있다.
		}
		
		for(int i = 0; i < T; i++) {
			bw.write(DP[Integer.parseInt(br.readLine())] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
