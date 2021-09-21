package java8;

import java.util.Scanner;

//이항계수 계산 (n개의 서로 다른 원소 중 r개의 원소를 순서없이 골라내는 방법의 수)
public class BinomialCoefficient {
	static int[][] cache = new int[30][30];
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n, r;
		n = scanner.nextInt();
		r = scanner.nextInt();
		for(int i = 0 ; i < cache.length ; i++){
			for(int j = 0 ; j < cache[0].length; j++){
				cache[i][j] = -1;
			}
		}
		System.out.println("결과: " + bino(n,r));
		
	}
	//(n, r) = (n-1, r-1) + (n-1, r)의 점화식이 성립
	static int bino(int n, int r){
		if(r == 0 || n == r){
			return 1;
		}
		if(cache[n][r] != -1){
			return cache[n][r];
		}
		return cache[n][r] = bino(n-1, r-1) + bino(n-1, r);
	}
}
