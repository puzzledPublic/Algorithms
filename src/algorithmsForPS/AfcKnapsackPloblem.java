package algorithmsForPS;

import java.util.Arrays;
import java.util.Scanner;

// 0/1 배낭문제 (S)
public class AfcKnapsackPloblem {
	static int N, W;
	static int info[][];
	static int cache[][] = new int[10001][1001];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		W = input.nextInt();
		info = new int[N][2];
		for(int i = 0; i < N; i++) {
			info[i][0] = input.nextInt();
			info[i][1] = input.nextInt();
		}
		for(int i = 0 ; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(solve(W, 0));
	}
	
	static int solve(int leftWeight, int pos) {
		if(pos == N) {
			return 0;
		}
		if(cache[leftWeight][pos] != -1) {
			return cache[leftWeight][pos];
		}
		if(leftWeight < info[pos][0]) {
			return cache[leftWeight][pos] = solve(leftWeight, pos + 1);
		}
		return cache[leftWeight][pos] = Math.max(solve(leftWeight, pos + 1), solve(leftWeight - info[pos][0], pos + 1) + info[pos][1]);
		
	}

}
