package programmers;
//서울에서 경산까지
public class FromSeoulToGyeongsan {
	public static void main(String[] args) {
		int[] K = {1650, 3000};
		int[][][] travel = {
				{{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}},
				{{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}}
		};
		for(int i = 0; i < K.length; i++) {
			System.out.println(solution(K[i], travel[i]));
		}
	}
	static int[][] dp;	//dp[i][j] = i번째 도시에 도착하고 j시간을 썼을때 최대 모금액
	static int solution(int K, int[][] travel) {
        int answer = 0;
        dp = new int[travel.length + 1][K + 1];
        answer = solve(travel, 0, 0, K);
        
        return answer;
    }
	
	static int solve(int[][] travel, int n, int time, int K) {
		if(n == travel.length) {
			return 0;
		}
		if(dp[n][time] != 0) {
			return dp[n][time];
		}
		if(time + travel[n][0] <= K) {	//도보로 가는 경우
			dp[n][time] = solve(travel, n + 1, time + travel[n][0], K) + travel[n][1];
		}
		if(time + travel[n][2] <= K) {	//자전거로 가는 경우
			dp[n][time] = Math.max(dp[n][time], solve(travel, n + 1, time + travel[n][2], K) + travel[n][3]);
		}
		return dp[n][time];
	}
}
