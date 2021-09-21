package programmers;

import java.util.HashSet;
import java.util.Set;

//소수 찾기
public class SearchingPrimeNumber {
	public static void main(String[] args) {
		String[] numbers = {
				"17", 
				"011",
		};
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(solution(numbers[i]));
		}
	}
	static Set<Integer> set = new HashSet<>();
	static int solution(String numbers) {
        int answer = 0;
        char[] nums = new char[numbers.length()];
        for(int i = 0; i < nums.length; i++) {
        	nums[i] = numbers.charAt(i);
        }
        int n = numbers.length();
        
        for(int i = 1; i < (1 << n); i++) {	//조합 구하기
        	char[] temp = new char[7];
        	boolean[] chk = new boolean[7];
        	int k = 0;
        	for(int j = 0; j < n; j++) {
        		if((i & (1 << j)) > 0) {
        			temp[k++] = nums[j];
        		}
        	}
        	answer += solve(temp, chk, k, 0, "");
        }
        
        return answer;
    }
	
	static int solve(char[] temp, boolean[] chk, int k, int start, String number) {	//순열 구하기
		if(start == k) {
			int num = Integer.parseInt(number);	//숫자를 구했으면 이미 탐색한 숫자인지 확인 후 소수 검사
			if(!set.contains(num)) {
				if(isPrime(num)) {
					set.add(num);
					return 1;
				}
			}
			return 0;
		}
		int result = 0;
		for(int i = 0; i < k; i++) {
			if(!chk[i]) {
				chk[i] = true;
				result += solve(temp, chk, k, start + 1, number + temp[i]);
				chk[i] = false;
			}
		}
		return result;
	}
	
	static boolean isPrime(int n) {		//소수 판별하기
		if(n <= 1) {
			return false;
		}
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
