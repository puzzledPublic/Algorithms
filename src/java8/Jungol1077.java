package java8;

import java.util.Scanner;

public class Jungol1077 {
	static int N, W;
	static int arr[][]; 
	static int cache[];
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		W = input.nextInt();
		arr = new int[N][2];
		cache = new int[10001];
		for(int i = 0 ; i < N; i++){
			for(int j = 0 ; j < 2; j++) {
				arr[i][j] = input.nextInt();
			}
		}
	
		System.out.println(sack(0));
		
	}
	static int sack(int weight) {
		
		if(cache[weight] != 0) {
			return cache[weight];
		}
		
		for(int i = 0 ; i < N; i++) {
			if(weight + arr[i][0] > W) {
				continue;
			}
			cache[weight] = Math.max(cache[weight], sack(weight + arr[i][0]) + arr[i][1]);
		}
		
		return cache[weight];
	}
}
