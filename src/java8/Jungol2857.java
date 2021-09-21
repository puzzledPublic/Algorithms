package java8;

import java.util.Scanner;

//세로읽기 KOI 2015 초등부
public class Jungol2857 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char arr[][] = new char[5][15];
		
		for(int i = 0 ; i < 5; i++){
			arr[i] = input.next().toCharArray();
		}
		for(int i = 0 ; i < 15; i++){
			for(int j = 0 ; j < arr.length; j++){
				if(arr[j].length > i){
					System.out.print(arr[j][i]);
				}
				else{
					continue;
				}
			}
		}
	}
}
