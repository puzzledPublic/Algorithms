package kakao.kakao2017;

import java.util.Stack;

//4단 고음
public class FourStageHighNote {
	public static void main(String[] args) {
		int[] n = {15, 24, 41, 2147483647};
		
//		for(int i = 0; i < n.length; i++) {
//			System.out.println(solution(n[i]));
//		}
		System.out.println(solution(n[3]));
	}
	
	static int solution(int n) {
		int answer = 0, k = 1;
		long start = 5, limit = 5, t = 3;
		while(true) {
			if(start <= n && n <= limit) {
				break;
			}
			if(n < start) {
				return 0;
			}
			k++;
			t *= 3;
			start = t + k * 2;
			limit = limit * 3 + 2;
		}
		
		answer = solve(n, k, 0, 0);
		return answer;
	}
	
	static int solve(int n, int k, int star, int plus) {
		if(star * 2 > plus) {
			return 0;
		}
		if(k == star) {
			if(n == 1) {
				return 1;
			}
			return 0;
		}
		int result = 0;
		if(star != k && n % 3 == 0) {
			result += solve(n / 3, k, star + 1, plus);
		}
		if(plus != 2 * k) {
			result += solve(n - 1, k, star, plus + 1);
		}
		return result;
	}
	
}
