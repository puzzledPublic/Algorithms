package java8;

import java.util.Arrays;
import java.util.Scanner;

//대표값2(KOI 본선 2005 초등)
public class Jungol1346 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int arr[] = new int[5];
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++){
			sum += arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}
}
