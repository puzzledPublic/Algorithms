package java8;

import java.util.Scanner;

public class Jungol1338 {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		textTriangle(n);
	}
	public static void textTriangle(int n){
		char text = 'A';
		char[][] arr = new char[n][n];
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < n; j++){
				arr[i][j]=' ';
			}
		}
		for(int i = 0 ; i < n ; i++){
			for(int j = i, k = n - 1;j < n; j++, k--){
				arr[j][k] = text++;
				if(text == 'Z' + 1){
					text = 'A';
				}
			}
		}
		
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
