package java8;

import java.util.Scanner;

//덩치 KOI 2013 초등부
public class Jungol2605 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[][] arr = new int[N][3];
		for(int i = 0 ; i < N; i++){
			arr[i][0] = input.nextInt();
			arr[i][1] = input.nextInt();
		}
		for(int i = 0 ; i < N; i++){
			for(int j = 0 ; j < N; j++){
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
					arr[i][2]++;
				}
			}
		}
		for(int i = 0 ; i < N; i++){
			System.out.print((arr[i][2] + 1) + " ");
		}
	}
}
