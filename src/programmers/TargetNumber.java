package programmers;
//타겟 넘버
public class TargetNumber {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
	static int dfs(int[] numbers, int n, int sum, int target) {
		if(n == numbers.length) {
			if(sum == target) {
				return 1;
			}
			return 0;
		}
		//현재 숫자의 음수를 또는 양수를 더하는 경우가 있다.
		return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
	}
}
