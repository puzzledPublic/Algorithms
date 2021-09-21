package algorithmsForPS;

import java.util.Arrays;

public class Afc01KnapsackPloblem {
	
	static int cache[][] = new int[100][10000];
	static int cache2[][] = new int[100][10000];
	static int amountOfThing = 4;
	static int weightOfKnapsack = 5;
	static int weight[] = {2, 1, 3, 2 };
	static int price[] = {3, 2, 3, 2 };
	public static void main(String[] args) {
		for(int i = 0 ; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(knapsack(0, weightOfKnapsack));
		
		System.out.println(knapsack2());
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(cache2[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int knapsack(int k, int r) {
		if(cache[k][r] != -1) {
			return cache[k][r];
		}
		
		if(k == amountOfThing) {
			return cache[k][r] = 0;
		}
		else if(weight[k] > r) {
			return cache[k][r] = knapsack(k + 1, r);
		}
		else {
			return cache[k][r] = Math.max(knapsack(k + 1, r),  knapsack(k + 1, r - weight[k]) + price[k]);
		}
	}
	
	static int knapsack2() {
		for(int i = amountOfThing - 1; i >= 0 ; i--) {
			for(int j = 0 ; j <= weightOfKnapsack ;  j++) {
				if(j < weight[i]) {
					cache2[i][j] = cache2[i+1][j];
				}
				else {
					cache2[i][j] = Math.max(cache2[i+1][j], cache2[i+1][j - weight[i]] + price[i]);
				}
			}
		}
		return cache2[0][weightOfKnapsack];
	}
}
