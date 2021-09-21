package programmers;

//쿠키 구입
public class BuyingCookie {
	public static void main(String[] args) {
		int[][] cookie = {
				{1, 1, 2, 3},
				{1, 2, 4, 5},
				{1, 3, 3, 1, 1},
				{1, 2, 3, 4, 5, 6},
				{3, 1, 2}
		};
		for(int i = 0; i < cookie.length; i++) {
			System.out.println(solution(cookie[i]));
		}
	}
	static int[] pSum;
	static int solution(int[] cookie) {
		int answer = 0;
		pSum = new int[cookie.length + 1];
		for(int i = 1; i < pSum.length; i++) {	//부분합
			pSum[i] = pSum[i - 1] + cookie[i - 1];
		}
		for(int i = 1; i < pSum.length - 1; i++) {	//모든 범위에 대해
			for(int j = pSum.length - 1; j > i; j--) {
				int r = find(i, j);		//이분탐색으로 양 쪽의 값이 같은지 검사
				if(answer < r) {
					answer = r;
				}
			}
		}
        return answer;
    }
	static int find(int start, int end) {
		int i = start, j = end;
		while(start < end) {
			int mid = (start + end) / 2;
			int s1 = pSum[mid] - pSum[i - 1], s2 = pSum[j] - pSum[mid];
			if(s1 == s2) {
				return s1;
			}else if(s1 < s2) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return 0;
	}
}
