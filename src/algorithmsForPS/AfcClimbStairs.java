package algorithmsForPS;

import java.util.Scanner;

public class AfcClimbStairs {
	static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		
		System.out.println(solve(0));
	}
	
	static int solve(int c) {
		if(c > N) {
			return 0;
		}
		if(c == N) {
			return 1;
		}
		
		return solve(c+1) + solve(c+2);
	}
}
