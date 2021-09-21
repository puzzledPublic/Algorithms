package programmers;
//타일 장식물
public class TileDecoration {
	public static void main(String[] args) {
		int[] N = {1, 5, 80};
		
		for(int i = 0; i < N.length; i++) {
			System.out.println(solution(N[i]));
		}
	}
	
	static long solution(int N) {
        long answer = 0;
        long[] dp = new long[81];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        answer = dp[N] * 2 + (dp[N] + dp[N - 1]) * 2;
        return answer;
    }
}
