package java8;

import java.util.Arrays;
import java.util.Scanner;

public class Jungol2258 {
	static int ret;
	static int arr[] = new int[3];
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		for(int i = 0; i < N; i++){
			arr[0] = input.nextInt();
			arr[1] = input.nextInt();
			arr[2] = input.nextInt();
			ret = Math.max(ret, maxPrize());
		}
		System.out.println(ret);
		
	}
	static int maxPrize(){
		int result = 0, count = 0, multi;
		Arrays.sort(arr);
		multi = arr[2];
		for(int i = 1 ; i < 3; i++){
			if(arr[i-1] == arr[i]){
				multi= arr[i];
				count++;
			}
		}
		switch(count){
		case 2:
			result = multi*1000+10000;
			break;
		case 1:
			result = multi*100+1000;
			break;
		default:
			result = multi*100;
			break;
		}
		return result;
	}
}
