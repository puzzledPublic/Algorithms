package java8;

import java.util.Scanner;

//색종이(중)
//가로, 세로 길이가 각각 100인 정사각형의 도화지가 있다.
//가로, 세로 길이가 각각 10인 검은색 종이들이 도화지에 평행하여 붙여졌을때 색종이가 붙은 영역의 둘레를 구하라
//입력 색종이 숫자 N ( N <= 100)과 N개의 자연수(x , y) 좌표
public class Jungol1671 {
	static boolean[][] dohwaji = new boolean[102][102];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, x, y, count = 0;
		//색종이 수 입력
		n = scanner.nextInt();
		//색종이 좌표를 입력 받아 바로 도화지에 그린다(true로 표시)
		for (int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					dohwaji[j][k] = true;
				}
			}
		}
		//도화지 전체 탐색
		for (int i = 1; i < dohwaji.length - 1; i++) {
			for (int j = 1; j < dohwaji[0].length - 1; j++) {
				//현재위치가 true(검은색)이라면
				if (dohwaji[i][j] == true) {
					//상하좌우를 살피며 false(흰색)이라면 테두리라 보고 둘레 길이 증가
					//상
					if (dohwaji[i - 1][j] == false) {
						count++;
					}
					//하
					if (dohwaji[i + 1][j] == false) {
						count++;
					}
					//우
					if (dohwaji[i][j + 1] == false) {
						count++;
					}
					//좌
					if (dohwaji[i][j - 1] == false) {
						count++;
					}
					
				}
			}
		}
		System.out.println(count);
	}
}
