package swExpertAcademy.D2;

import java.util.Scanner;

public class SWEA2072 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 0; j < 10; j++) {
				int curr = input.nextInt();
				if(curr % 2 != 0) {
					sum += curr;
				}
			}
			System.out.println("#" + i + " " + sum);
		}
	}
}
