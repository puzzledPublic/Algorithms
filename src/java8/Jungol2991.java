package java8;

import java.util.Scanner;

//방 배정(KOI2016 초등부)
public class Jungol2991 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N, K;
		int arr[][] = new int[7][2];
		int count = 0;
		N = input.nextInt();
		K = input.nextInt();
		for(int i = 0 ; i < N ; i++){
			if(input.nextInt() == 1){
				arr[input.nextInt()][1]++;
			}else{
				arr[input.nextInt()][0]++;
			}
		}
		
		for(int i = 1 ; i < arr.length; i++){
			for(int j = 0 ; j < arr[0].length; j++){
				if(arr[i][j]%K != 0){
					count+=arr[i][j]/K+1;
				}else{
					count+=arr[i][j]/K;
				}
			}
		}
		System.out.println(count);
	}
}
