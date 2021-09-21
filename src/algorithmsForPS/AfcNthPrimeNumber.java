package algorithmsForPS;

import java.util.Scanner;

//n번째 소수 구하기  (1 <= n <= 100000)
public class AfcNthPrimeNumber {
	static boolean[] erasto = new boolean[100000];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		erasto[0] = true;
		erasto[1] = true;
		
		System.out.println(solve(n));
	}
	
	static int solve(int number) {
		for(int i = 2; i * i < erasto.length; i++) {
			if(erasto[i] == false) {
				for(int k = i; k * i < erasto.length && k < erasto.length; k++) {
					erasto[k * i] = true;
				}
			}
		}
		int count = 0;
		int result = 0;
		for(int i = 2 ; i < erasto.length; i++) {
			if(erasto[i] == false) {
				count++;
			}
			if(count == number) {
				result = i;
				break;
			}
		}
		return result;
	}
}
