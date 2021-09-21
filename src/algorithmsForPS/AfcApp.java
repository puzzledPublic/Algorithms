package algorithmsForPS;

import java.util.Arrays;
import java.util.Scanner;

public class AfcApp {
	
	static int amountOfApp = 5;
	static int needMemory = 60;
	
	static int takeMemory[] = {30, 10, 20, 35, 40};
	static int takeCost[] = {3, 0, 3, 5, 4};
	
	static int takeMemory2[] = {0, 30, 10, 20, 35, 40};
	static int takeCost2[] = {0, 3, 0, 3, 5, 4};
	
	static int cache[][] = new int[100][10000];
	static int res = 100000;
	
	public static void main(String[] args) {
		
		/*
			Scanner input = new Scanner(System.in);
			
			amountOfApp = input.nextInt();
			needMemory = input.nextInt();
		
			takeMemory = new int[amountOfApp];
			takeCost = new int[amountOfApp];
			
			for(int i = 0 ; i < amountOfApp ; i++) {
				takeMemory[i] = input.nextInt();
			}
			for(int i = 0 ; i < amountOfApp ; i++) {
				takeCost[i] = input.nextInt();
			}
		*/
		
		System.out.println(app(0, needMemory));
		
		System.out.println(app2());
	}
	
	//O(2^n) 시간 내 불가	app(k,r) = k ~ amountOfApp까지 고려시 남은 메모리가 r인 비용의 최소 합	(
	//메모이제이션을 하기엔 메모리 잡는 크기가 초과돼서 다른 방법 필요.
	public static int app(int k, int r) {
		
		if(k == amountOfApp) {
			if(r <= 0) {
				return 0;
			}
			return 2464575;
		}
		if(r < 0) {
			return app(k + 1, r);
		}
		else {
			return Math.min(app(k + 1, r), app(k + 1, r - takeMemory[k]) + takeCost[k]); 
		}
	}
	//문제를 바꿔 푸는 경우 app2(k, r) = 1 ~ k까지 앱을 고려시 비용이 r인 메모리의 최대 합
	public static int app2() {
		
		for(int i = 1 ; i < amountOfApp + 1 ; i++) {
			for(int j = 0 ; j < amountOfApp * 100 + 1 ; j++) {
				if(j >= takeCost2[i]) {
					cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j - takeCost2[i]] + takeMemory2[i]);
				}
				else {
					cache[i][j] = cache[i-1][j];
				}
			}
		}
		
		for(int i = 0 ; i < amountOfApp * 100 + 1 ; i++) {
			if(cache[amountOfApp][i] >= needMemory && res > i) {
				res = i;
			}
		}
		return res;
	}
}
