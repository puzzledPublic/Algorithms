package programmers;
//소수 만들기
public class MakingPrimeNumber {
	public static void main(String[] args) {
		int[][] nums = {
				{1,2,3,4},
				{1,2,7,6,4}
		};
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(solution(nums[i]));
		}
	}
	
	static int solution(int[] nums) {
        int answer = -1;
        boolean[] chk = new boolean[nums.length];
        answer = recur(nums, chk, 0, 0);
        return answer;
    }
	
	static int recur(int[] nums, boolean[] chk, int n, int next) {
		if(n == 3) {
			int sum = 0;
			for(int i = 0; i < chk.length; i++) {
				if(chk[i]) {
					sum += nums[i];
				}
			}
			if(isPrime(sum)) {
				return 1;
			}
			return 0;
		}
		int result = 0;
		for(int i = next; i < nums.length; i++) {
			if(!chk[i]) {
				chk[i] = true;
				result += recur(nums, chk, n + 1, i + 1);
				chk[i] = false;
			}
		}
		return result;
	}
	static boolean isPrime(int n) {
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
