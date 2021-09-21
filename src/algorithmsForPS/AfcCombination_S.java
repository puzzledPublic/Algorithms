package algorithmsForPS;

import java.util.Arrays;

//nCr n개중 r개를 고르는 경우의 수를 출력하라 (문제해결을 위한 창의적 알고리즘)
//nCr = n! / r! * (n - r)!
//위 공식은 n or r이 크면 팩토리얼때문에 컴퓨터 계산시 오래걸림
public class AfcCombination_S {
	static int cache[][] = new int[31][31];
	static int cache3[][] = new int[31][31];
	static int N = 5, R = 2;
	public static void main(String[] args) {
		for(int i = 0 ; i < cache3.length; i++) {
			Arrays.fill(cache3[i], -1);
		}
		
		System.out.println(solve(5,2));
		System.out.println(solve2(5,2));
		System.out.println(solve3(5,2));
		System.out.println(solve4(5,2));
		System.out.println(solve5(0,0));
	}
	//f(n,r) = n (n == r)
	//f(n,r) = 1 (r == 1)
	//f(n,r) = f(n-1, r-1) + f(n-1, r)  (1<r<n)
	static int solve(int n, int r){
		
		if(n == r){
			return 1;
		}
		else if(r == 1){
			return n;
		}
		else{
			return solve(n - 1, r - 1) + solve(n - 1, r);
		}
	}
	//개량 버전 f(n,r) = f(n, r-1) * (n - r + 1) / r (1<r<n)
	static int solve2(int n, int r){
		if(n == r){
			return 1;
		}
		else if(r == 1){
			return n;
		}
		else{
			//return solve2(n, r - 1) * (n - r + 1) / r; //오버플로우 발생 가능성
			return (n - r + 1) / r * solve2(n, r - 1);
		}
	}
	//하향식 접근 방법 (메모이제이션)
	static int solve3(int n, int r) {
		if(n == r) {
			cache[n][r] = 1;
		}
		else if(r == 1) {
			cache[n][r] = n;
		}
		else {
			if(cache[n][r] == 0) {
				cache[n][r] = solve3(n - 1, r - 1) + solve3(n - 1, r);
			}
		}
		return cache[n][r];
	}
	//상향식 접근 방법 (반복식)
	static int solve4(int n, int r) {
		int cache2[][] = new int[31][31];
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1 ; j <= r && j <= i; j++) {
				if(i == j) {
					cache2[i][j] = 1;
				}
				else if(j == 1) {
					cache2[i][j] = i;
				}
				else {
					cache2[i][j] = cache2[i-1][j-1] + cache2[i-1][j];
				}
			}
		}
		
		return cache2[n][r];
	}
	//다이나미컬 백트래킹
	static int solve5(int n, int r) {
		if(r == R) {
			return 1;
		}
		if(n == N) {
			return 0;
		}
		if(cache3[n][r] == -1) {
			cache3[n][r] = solve5(n + 1, r + 1) + solve5(n + 1, r);
		}
		return cache3[n][r];
	}
}
