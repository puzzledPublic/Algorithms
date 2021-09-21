package java8;

import java.util.Scanner;
//달팽이 사각형
public class Jungol1707 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n < 1 || n > 100) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}

		//snailSquare(n);
		snailSquare2(n);
	}

	public static void snailSquare(int n) {
		int[][] arr = new int[n][n];
		int num = 1;
		int x = 0, y = -1;
		while (n > 0) {
			for (int i = 0; i < n; i++) {
				y++;
				arr[x][y] = num++;
			}
			n--;
			for (int i = 0; i < n; i++) {
				x++;
				arr[x][y] = num++;
			}
			for (int i = 0; i < n; i++) {
				y--;
				arr[x][y] = num++;
			}
			n--;
			for (int i = 0; i < n; i++) {
				x--;
				arr[x][y] = num++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void snailSquare2(int n){
		int[][] arr= new int[n+2][n+2];
		
		int x = 1, y = 0;
		int num = 1;
		
		for(int i = 0 ; i < n+2; i++){
			arr[0][i] = arr[n+1][i] = 1;
			arr[i][0] = arr[i][n+1] = 1;
		}
		while(num <= n*n){
			while(arr[x][y+1] == 0){
				y++;
				arr[x][y] = num++;
			}
			while(arr[x+1][y] == 0){
				x++;
				arr[x][y] = num++;
			}
			while(arr[x][y-1] == 0){
				y--;
				arr[x][y] = num++;
			}
			while(arr[x-1][y] == 0){
				x--;
				arr[x][y] = num++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
