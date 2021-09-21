package programmers;
//올바른 괄호의 갯수
public class NumberOfCorrectParenthese {
	public static void main(String[] args) {
		int[] n = {2, 3, 14};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}
	
	static int solution(int n) {
        int answer = 0;
        
        answer = solve(0, 0, n);
        
        return answer;
    }
	
	static int solve(int a, int b, int n) {		//'('를 a개 ')'를 b개 사용했을때 가능한 올바른 괄호의 개수
		if(a == n && b == n) {	//모두 사용했으면 갯수 +1
			return 1;
		}
		int result = 0;
		
		if(a < n) {		//'('를 n개까지 사용할 수 있다.
			result += solve(a + 1, b, n);
		}
		if(a > b) {		//')'를 이미 '('를 사용한 갯수보다 더 많이 사용하면 올바른 괄호를 만들 수 없다.
			result += solve(a, b + 1, n);
		}
		
		return result;
	}
}
