package java8;

import java.util.Scanner;

//리조트(KOI 2016 초등/고등) ..ing
public class Jungol2993 {
	
	static int coupon;
	static boolean days[] = new boolean[101];
	static int N, M;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		M = input.nextInt();
		for(int i = 0; i < M; i++){
			days[input.nextInt()] = true;
		}
		int result = price(1,0);
		System.out.println(result);
		
	}
	private static int price(int i, int j){
		if(i > N){
			return 0;
		}
		while(days[i] == true){
			i++;
		}
		if(j>=3){
			j-=3;
			i++;
			while(days[i]==true){
				i++;
			}
		}
		return Math.min(Math.min(price(i+5,j+2)+37000,price(i+3,j+1)+25000), price(i+1,j)+10000);
	}
}
