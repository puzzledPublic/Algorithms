package java8;

import java.util.Arrays;
import java.util.Scanner;
//두 줄로 타일 깔기 
public class Jungol1411{
	final static int MOD = 20100529;
	static int[] arr = new int[100001];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		arr[1] = 1;
		arr[2] = 3;
		
		for(int i = 3; i < N + 1; i++){
			arr[i] = (arr[i-1]+arr[i-2]*2)%MOD;
		}
		System.out.println(arr[N]);
	}
}
//스택 오버 플로우
/*
public class Jungol1411 {
	final static int MOD = 20100529;
	static int[] cache = new int[100001];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		Arrays.fill(cache, -1);
		System.out.println(tile(N));
		
	}
	
	static int tile(int width){
		if(width <= 1){
			return 1;
		}
		
		if(cache[width] != -1){
			return cache[width];
		}
		return cache[width] = ((tile(width-2)*2)+tile(width-1))%MOD;
	}
}
*/