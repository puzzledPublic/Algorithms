package java8;

import java.util.Arrays;
import java.util.Scanner;

//홀수, KOI 2006 초등부
public class Jungol1392 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int arr[] = new int[7];
		int sum = 0, count = 0;
		int min = 0;
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = input.nextInt();
			
		}
		Arrays.sort(arr);
		
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i]%2 == 1){
				if(count == 0){
					min = arr[i];
				}
				count++;
				sum += arr[i];
			}
		}
		if(count == 0){
			System.out.println(-1);
		}
		else{
			System.out.println(sum+"\n"+min);
		}
	}
}
