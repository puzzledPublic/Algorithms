package java8;

import java.util.Arrays;
import java.util.Scanner;

//종만북 8.14
//폴리오미노
//n개의 정사각형으로 구성된 세로 단조 폴리오미노의 개수 출력하라
// 1 <= n <= 100
//개수가 10,000,000이상인 경우 10,000,000으로 나눈 나머지를 출력
public class Polyomino {
	final static int MOD = 10*1000*1000;
	static int[][] cache = new int[101][101];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		int result = 0;
		for(int i = 1 ; i <= n; i++){
			result += poly(n,i);
		}
		System.out.println(result);
	}

	//첫줄이 first개로 이루어진 n개의 정사각형으로 만들 수 있는 폴리오미노 개수를 리턴 
	static int poly(int n, int first) {
		if(n == first){
			return 1;
		}
		if(cache[n][first] != -1){
			return cache[n][first];
		}
		cache[n][first] = 0;
		for(int second = 1; second <= n-first; second++){
			int add = second + first - 1;
			add *= poly(n-first, second);
			add %= MOD;
			cache[n][first] += add;
			cache[n][first] %= MOD;
		}
		return cache[n][first];
	}
}
