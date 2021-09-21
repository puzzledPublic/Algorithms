package algorithmsForPS;

import java.util.Scanner;

//오른편 절단 가능 소수(문제해결을 위한 창의적 알고리즘(중급))
public class AfcRightTruncatablePrime {
	
	static int N;
	static int cnt;
	static int cnt2;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		
		solve(0,0);
		
		System.out.println(cnt);
		
		solve2(2,1);
		solve2(3,1);
		solve2(5,1);
		solve2(7,1);
		
		System.out.println(cnt2);
	}
	
	static void solve(int num, int len) {
		if(len == N) {
			if(num == 0) {
				return;
			}
			int temp = num;
			while(temp != 0) {
				if(!isPrime(temp)) {
					return;
				}
				temp /= 10;
			}
			cnt++;
			System.out.println(num);
			return;
		}
		else {
			for(int i = 1; i < 10; i++) {
				solve(num * 10 + i, len + 1);
			}
		}
	}
	//가지치기 하여 계산량을 감소
	static void solve2(int num, int len) {
		if(len == N) {
			if(isPrime(num)) {
				cnt2++;
				System.out.println(num);
			}
			return;
		}
		else {
			if(isPrime(num)) {
				solve2(num * 10 + 1, len + 1);
				solve2(num * 10 + 3, len + 1);
				solve2(num * 10 + 7, len + 1);
				solve2(num * 10 + 9, len + 1);
			}
		}
	}
	static boolean isPrime(int num) {
		if(num < 2) {
			return false;
		}
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
