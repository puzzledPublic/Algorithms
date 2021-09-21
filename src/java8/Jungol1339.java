package java8;

import java.util.Scanner;

//¹®ÀÚ »ï°¢Çü
public class Jungol1339 {

	public static void main(String args[]) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		if (n % 2 == 0 || n >100 || n < 1) {
			System.out.println("INPUT ERROR");
			System.exit(0);
		}
		textTriangle2(n);
		scanner.close();
	}

	static void textTriangle2(int n) {
		char text = 'A';
		char[][] arr = new char[n][n];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n; j++){
				arr[i][j]=' ';
			}
		}
		for (int i = n / 2, k = n / 2; i >= 0; i--, k++) {
			for (int j = i; j <= k; j++) {
				arr[j][i] = text++;
				if(text >'Z'){
					text = 'A';
				}
			}
		}
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
