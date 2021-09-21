package programmers;

//사칙연산
public class FourFundamentalRulesOfArithmetics {
	public static void main(String[] args) {
		String[][] arr = {
				{"1", "-", "5", "-", "3"},
				{"1", "-", "3", "+", "5", "-", "8"},
				{"5", "-", "3", "-", "1", "-", "2"},
				{"5", "-", "3", "+", "1", "+", "2", "-", "4"}
		};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(solution(arr[i]));
		}
	}
	
	static int[][] dp;
	static int solution(String arr[]) {
		int answer = 1;
		int N = arr.length;
		
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {						
				dp[i][j] = Integer.MIN_VALUE;
			}
			if(i % 2 == 0) {
				dp[i][i] = Integer.parseInt(arr[i]);	//i~i까지의 연산 결과는 자기자신
				
			}
		}
		answer = solve(arr, 0, N - 1);
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print((dp[i][j] == Integer.MIN_VALUE ? "+" : dp[i][j]) + " ");
//			}
//			System.out.println();
//		}
		
		return answer;
	}
	
	static int solve(String[] arr, int a, int b) {	//solve(arr, a, b) -> a ~ b까지 연산 결과의 최대값. = solve(arr, a, i) '+' or '-' solve(arr, i + 2, b) (for i = a ~ b - 2)
		if(dp[a][b] != Integer.MIN_VALUE) {
			return dp[a][b];
		}

		if(a - 1 >= 1 && arr[a - 1] == "-") {	//앞에 '-'가 붙으면 그 뒤의 연산 결과는 최소값이 나와야 최대로 높일 수 있다.
			int result = Integer.MAX_VALUE;
			for(int i = a; i < b; i += 2) {
				if(arr[i + 1] == "-") {
					result = Math.min(result, solve(arr, a, i) - solve(arr, i + 2, b));
				}else {
					result = Math.min(result, solve(arr, a, i) + solve(arr, i + 2, b));
				}
			}
			dp[a][b] = result;
		}else {	//앞에 '+'가 붙으면 그 뒤의 연산 결과는 최대값이 나와야 최대로 높일 수 있다.
			int result = Integer.MIN_VALUE;
			for(int i = a; i < b; i += 2) {
				if(arr[i + 1] == "-") {
					result = Math.max(result, solve(arr, a, i) - solve(arr, i + 2, b));
				}else {
					result = Math.max(result, solve(arr, a, i) + solve(arr, i + 2, b));
				}
			}
			dp[a][b] = result;
		}
		return dp[a][b];
	}
}
