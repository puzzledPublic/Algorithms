package algorithmsForPS;

import java.util.Scanner;

public class AfcDivisorSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		long number = input.nextLong();
		
		if(number > 2) {
			System.out.println(solve(number) + 1);
		} else {
			System.out.println(0);
		}
		
		
		System.out.println(solve2(number) - number);
	}
	
	static long solve2(long number) {
		long i, ans = 0;
		
		for(i = 1; i*i< number; i++) {
			if(number % i == 0) {
				ans += (i + number / i);
			}
		}
		if(i * i == number) {
			ans += i;
		}
		return ans;
	}
	static long solve(long number) {
		
		long limit = number;
		long result = 0;
		
		for(long i = 2; i < limit; i++) {
			if(number % i == 0) {
				limit = number / i;
				if(i == limit) { 
					result += i;
				}else {
					result += (i + limit);
				}
			}
		}
		
		return result;
	}
}
