package java8;

import java.util.Scanner;

public class Jungol1744 {
	static int[][] arr = new int[3][4];
	static int[] results = new int[3];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++){
			for(int j = 0 ; j < 4; j++){
				if((arr[i][j] = input.nextInt()) == 0){
					results[i]++; 
				}
			}
		}
		
		for(int i = 0 ; i < 3; i++){
			switch(results[i]){
				case 1:
					System.out.println("A");
					break;
				case 2:
					System.out.println("B");
					break;
				case 3:
					System.out.println("C");
					break;
				case 4:
					System.out.println("D");
					break;
				default:
					System.out.println("E");
					break;
			}
		}
	}
}
