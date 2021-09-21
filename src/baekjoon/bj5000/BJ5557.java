package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1학년
public class BJ5557 {
	static long[][] dp = new long[101][21];	//dp[i][j] = i번째 숫자까지 j가 만들어졌을때의 경우의 수
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long result = solve(1, arr[0]);	//초기시작 값은 arr[0]
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
	static long solve(int n, int val) {
		if(n == arr.length - 1) {	//숫자를 모두 사용했고
			if(val == arr[arr.length - 1]) {	//계산 결과가 마지막 숫자와 같다면 경우 수 +1
				return dp[n][val] = 1;
			}
			return dp[n][val] = 0;	//아니라면 0
		}
		if(dp[n][val] != 0) {
			return dp[n][val];
		}
		
		if(0 <= val + arr[n] && val + arr[n] <= 20) {	//다음 숫자와 더한 경우
			dp[n][val] += solve(n + 1, val + arr[n]);
		}
		if(0 <= val - arr[n] && val - arr[n] <= 20) {	//다음 숫자와 뺀 경우
			dp[n][val] += solve(n + 1, val - arr[n]);
		}
		return dp[n][val];
	}
}
