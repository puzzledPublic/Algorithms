package java8;

import java.util.Scanner;

//마방진
public class Jungol2074 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n;
		// 입력
		n = scanner.nextInt();
		// 입력 체크
		if (n < 2 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		// 출력
		magicSquare(n);
	}

	static void magicSquare(int n) {
		// 배열 생성
		int mSquare[][] = new int[n][n];
		// 배열 위치를 나타낼 좌표 값 (시작 위치는 첫행, 중간열)
		int x = 0, y = n / 2;
		// 배열에 넣을 숫자 (1부터 시작)
		int count = 1;
		//숫자가 배열을 다 채울때까지
		while (count <= n * n) {
			//숫자를 배열에 넣고
			mSquare[x][y] = count;
			//현재 숫자가 n의 배수면 아래로
			if (count % n == 0) {
				x++;
			}
			//아니라면
			else {
				//왼쪽위로
				x--;
				y--;
				//만약 배열의 범위를 넘어서면 좌표 수정
				if (x < 0) {
					x = n-1;
				}
				if (y < 0) {
					y = n-1;
				}
			}
			//숫자 증가
			count++;

		}
		
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < n; j++){
				System.out.print(mSquare[i][j]+" ");
			}
			System.out.println();
		}
	}
}
