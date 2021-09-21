package algorithmsForPS;

import java.util.Scanner;

public class AfcTriangleGarden {
	static int gardenLength;
	static int count2;
	static int chk[][][] = new int[21][21][21];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		gardenLength = input.nextInt();
		
		System.out.println(getNumberOfGarden(gardenLength));
		
		getNumberOfGarden2(1, 1, 1);
		System.out.println(count2);
	}
	static int getNumberOfGarden(int gardenLength) {
		int count = 0;
		for(int i = 1 ; i < gardenLength + 1 ; i++) {
			for(int j = i ; j < gardenLength + 1 ; j++) {
				for(int k = j ; k < gardenLength + 1 ; k++) {
					if(i + j > k && i + j + k == gardenLength) {	//작은 2개의 변의 길이의 합이 나머지 변의 길이보다 커야 삼각형 성립, 또한 답을 위해 세변의 합이 가든의 길이와 같아야 함
						count++;
					}
				}
			}
		}
		return count;
	}
	
	static void getNumberOfGarden2(int a, int b, int c) {
		if(a + b + c == gardenLength) {
			if(a <= b && b <= c && a + b > c && chk[a][b][c] != 1) {
				chk[a][b][c] = 1;
				count2++;
			}
			return;
		}
		getNumberOfGarden2(a + 1, b, c);
		getNumberOfGarden2(a, b + 1, c);
		getNumberOfGarden2(a, b, c + 1);
	}
}
