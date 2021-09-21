package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//제곱수의 합
public class BJ1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write(solve(N) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int N) {
		int[] dp = new int[N + 1];	//dp[i] = 숫자 i를 나타내는 제곱수의 합들 중 가장 적은 갯수
		for(int i = 0; i < N + 1; i++) {
			dp[i] = 987654321;
		}
		dp[0] = 0;	//0일땐 없다.
		dp[1] = 1;	//1일땐 1^2뿐
		
		//dp[i] = dp[i - j^2] (1 <= j <= root(i))들 중 가장 작은 값 + 1이 된다.
		//즉 i가 되려면 i 이하의 어떤 수 + j^2를 더해야 i가 되고 그 어떤 수들의 제곱 수의 합들 중 가장 작은 값에 + 1을 더해주면 i의 가장 적은 제곱수의 합이 된다.
		for(int i = 2; i < N + 1; i++) {
			for(int j = 1; j * j <= i; j++) {	//dp[i] = min(dp[i - j * j] + 1) (1 <= j <= root(i))
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[N];
	}
}
