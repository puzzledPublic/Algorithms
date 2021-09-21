package programmers;
//DP-카드 게임
public class DPCardGame {
	public static void main(String[] args) {
		int[] left = {3, 2, 5};
		int[] right = {2, 4, 1};
		
		System.out.println(solution(left, right));
	}
	
	static int solution(int[] left, int[] right) {
        int answer = 0;
        int[][] dp = new int[left.length + 1][right.length + 1];	//dp[i][j] = left 카드가 i개 right 카드가 j개 남았을때 최대 점수값.
        
        for(int i = 1; i < left.length + 1; i++) {
        	for(int j = 1; j < right.length + 1; j++) {
//        		System.out.println(left[left.length - i] + " " + right[right.length - j]);
        		if(left[left.length - i] > right[right.length - j]) {	//오른쪽 카드 숫자가 더 작은 경우
        			dp[i][j] = Math.max(dp[i][j - 1] + right[right.length - j], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
        		}else {	//왼쪽, 오른쪽 카드 숫자가 같거나 왼쪽 카드 숫자가 더 큰 경우
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
        		}
        	}
        }
        answer = dp[left.length][right.length];
        return answer;
    }
}
