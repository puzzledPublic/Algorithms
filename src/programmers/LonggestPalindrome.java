package programmers;
//가장 긴 팰린드롬
public class LonggestPalindrome {
	public static void main(String[] args) {
		String[] s = {
				"abcdcba",
				"abacde",
				"aabbaa",
				"ab",
				"abca"
		};
		for(int i = 0; i < s.length; i++) {
			System.out.println(solution2(s[i]));
		}
	}
	//연속되는 부분문자열시	(s의 길이 2500이하)
	static int solution(String s) {
		int answer = 0;
		int max = 1;
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				if(max < j - i + 1) {
					int start = i, end = j;
					boolean chk = false;
					while(start <= end) {
						if(sb.charAt(start) != sb.charAt(end)) {
							chk = true;
							break;
						}
						start++;
						end--;
					}
					if(!chk) {
						max = j - i + 1;
					}
				}
			}
		}
		return answer = max;
	}
	//연속되는 부분문자열시 DP 풀이
	static int solution2(String s) {
		int answer = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];	//dp[i][j] = i ~ j까지의 문자열이 팰린드롬인지 여부
		for(int i = 0; i < s.length(); i++) {	//자기자신은 팰린드롬이다
			dp[i][i] = true;
		}
		for(int i = 0; i < s.length() - 1; i++) {	//길이가 2인 팰린드롬 "aa"도 미리 구해놓는다.
			if(s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
			}
		}
		int max = 1;
		//i ~ i + k문자열이 팰린드롬이 되려면 (i+1) ~ (i+k-1)이 팰린드롬이면서 s.charAt(i) == s.charAt(i + k)여야 한다.
		for(int k = 2; k < s.length(); k++) {	//길이가 2인 팰린드롬은 이미 구했으므로 k=2부터 시작하여 길이가 i+k인 팰린드롬을 구해본다.
			for(int i = 0; i < s.length() - k; i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					if(j - i + 1 > max) {
						max = j - i + 1;
					}
				}
			}
		}
		return max;
	}
	
	static int size;
	static int solution3(String s) {
        int answer = 0;
        size = s.length() - 1;
        int[][] dp = new int[size + 1][size + 1];
        answer = solve3(dp, s, 0, s.length() - 1);        
        return answer;
    }
	static int solve3(int[][] dp, String s, int left, int right) {	//부분문자열시
		if(left == right) {
			return dp[left][size - right] = 1;
		}
		if(left > right) {
			return 0;
		}
		if(dp[left][size - right] != 0) {
			return dp[left][size - right];
		}
		
		if(s.charAt(left) == s.charAt(right)) {
			dp[left][size - right] += solve3(dp, s, left + 1, right - 1) + 2;
		}else {
			dp[left][size - right] += Math.max(solve3(dp, s, left + 1, right), solve3(dp, s, left, right - 1));
		}
		return dp[left][size - right];
	}
	
}
