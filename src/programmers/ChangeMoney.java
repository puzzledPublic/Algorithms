package programmers;


//거스름 돈
public class ChangeMoney {
	public static void main(String[] args) {
		int[] n = { 5 };
		int[][] money = { { 1, 2, 5 } };
		for (int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], money[i]));
		}
	}
	static int solution(int n, int[] money) {
		int answer = 0;
		int[] dp = new int[n + 1];
		for(int i = 0; i < n + 1; i++) {
			dp[i] = i % money[0] == 0 ? 1 : 0;
		}
		for(int i = 1; i < money.length; i++) {
			for(int j = money[i]; j < n + 1; j++) {
				dp[j] = (dp[j] + dp[j - money[i]]) % 1000000007;
			}
		}
		return answer = dp[n];
	}
//	static int solve(int n, int[] money, int k) {
//		if(n == 0) {
//			return dp[n][k] = 1;
//		}
//		if(dp[n][k] != 0) {
//			return dp[n][k];
//		}
//		for(int i = k; i < money.length; i++) {
//			if(n - money[i] >= 0) {
//				dp[n][k] = (dp[n][k] + solve(n - money[i], money, i)) % 1000000007;
//			}
//		}
//		return dp[n][k];
//	}
}
