package java8;

import java.util.Scanner;
//파스칼 삼각형
public class Jungol2071 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int height, type;
		height = scanner.nextInt();
		type = scanner.nextInt();
		if (height < 1 || height > 30 || type < 1 || type > 3) {
			System.exit(0);
		}
		// 파스칼 삼각형 원소들을 넣을 배열
		int pascal[] = new int[height * (height + 1) / 2];
		// 파스칼 원소를 넣는다
		pascal[0] = 1;
		for (int i = 1; i < height; i++) {
			int temp = i * (i + 1) / 2;
			for (int j = i * (i + 1) / 2; j <= i * (i + 1) / 2 + i; j++) {
				if (j == i * (i + 1) / 2 || j == i * (i + 1) / 2 + i) {
					pascal[j] = 1;
				} else {
					pascal[j] = pascal[i * (i - 1) / 2 + (j - temp) - 1]
							+ pascal[i * (i - 1) / 2 + (j - temp)];
				}

			}
		}
		switch (type) {
		case 1:
			pascalTriangle1(height, pascal);
			break;
		case 2:
			pascalTriangle2(height, pascal);
			break;
		case 3:
			pascalTriangle3(height, pascal);
			break;
		}
	}

	static void pascalTriangle1(int height, int[] pascal) {
		for (int i = 0; i < height; i++) {
			for (int j = i * (i + 1) / 2; j <= i * (i + 1) / 2 + i; j++) {
				System.out.print(pascal[j] + " ");
			}
			System.out.println();
		}
	}

	static void pascalTriangle2(int height, int[] pascal) {
		for (int i = height - 1; i >= 0; i--) {
			for (int j = i + 1; j < height; j++) {
				System.out.print(" ");
			}
			for (int j = i * (i + 1) / 2 + i; j >= i * (i + 1) / 2; j--) {
				System.out.print(pascal[j] + " ");
			}
			System.out.println();
		}
	}

	static void pascalTriangle3(int height, int[] pascal) {
		int pascalArr[][] = new int[height][height];
		int count = 0;
		for (int i = height - 1; i >= 0; i--) {
			for (int j = height - 1; j >= i; j--) {
				pascalArr[j][i] = pascal[count++];
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(pascalArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
