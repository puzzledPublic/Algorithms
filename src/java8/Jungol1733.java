package java8;

import java.util.Scanner;

//오목
public class Jungol1733 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] omokpan = new int[19][19];
		for (int i = 0; i < omokpan.length; i++) {
			for (int j = 0; j < omokpan[0].length; j++) {
				omokpan[i][j] = scanner.nextInt();
			}
		}

		findWinner(omokpan);

	}

	static void findWinner(int[][] omokpan) {
		/*
		 * int count = 0; for (int i = 0; i < omokpan.length; i++) { for (int j
		 * = 0; j < omokpan[0].length - 4; j++) { if (omokpan[i][j] != 0) { //
		 * 오른쪽 for (int k = j; k < j + 4 && k < omokpan.length; k++) { if
		 * (omokpan[i][k] == omokpan[i][k + 1]) { count++; } else { count = 0;
		 * break; } } if (count == 4) { System.out.println(omokpan[i][j]);
		 * System.out.println((i + 1) + " " + (j + 1)); return; } // 대각선 위 for
		 * (int k = j, h = i; k < j + 4 && j < omokpan.length && h > 0; k++,
		 * h--) { if (omokpan[h][k] == omokpan[h - 1][k + 1]) { count++; } else
		 * { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } if (i < omokpan.length - 4) { // 대각선 아래 for (int
		 * k = j, h = i; k < j + 4 && k < omokpan.length && h < omokpan.length;
		 * k++, h++) { if (omokpan[h][k] == omokpan[h + 1][k + 1]) { count++; }
		 * else { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } // 아래 for (int k = i; k < i + 4 && k <
		 * omokpan.length; k++) { if (omokpan[k][j] == omokpan[k + 1][j]) {
		 * count++; } else { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } } } } } System.out.println("0");
		 */
		//한 좌표에 대해 오른쪽, 대각선 위, 대각선 아래, 아래를 검사해보면 된다.
		//주의할 점은 5개의 돌을 검사하는데 있어 바둑판의 크기를 넘어가거나 더 적어질 경우이다.
		//또 돌이 5개 이상 같을 때 5번째 6번째를 비교하고 또 5번째와 현재 좌표의 전 값을 비교 해봐야 한다
		boolean flag; // 오목 완성인지 표시하는 변수
		//바둑판을 돌면서
		for (int i = 0; i < omokpan.length; i++) {
			//세로줄은 오목판 폭의 -4를 한 값 만큼 돈다 (좌표의 5만큼 줄어들거나 늘어나므로)
			for (int j = 0; j < omokpan[0].length - 4; j++) {
				//
				if (omokpan[i][j] != 0) {
					flag = true;
					// 오른쪽 
					//현재 좌표에서 오른쪽으로 돌이 5개가 같은지 검사
					for (int k = j; k < j + 4 && k < omokpan.length; k++) {
						if (omokpan[i][k] != omokpan[i][k + 1]) {
							flag = false;
						}
					}
					//5번째와 6번째 비교(5개 이상이 같은지 검사)
					if (j + 5 < omokpan.length
							&& omokpan[i][j + 4] == omokpan[i][j + 5]) {
						flag = false;
					}
					//현재 좌표 전의 값과 5번째 비교 (중간부터 비교하는 경우가 있으므로 전 값 까지 검사 해본다)
					if(j>0 && omokpan[i][j + 4] == omokpan[i][j - 1]){
						flag = false;
					}
					//5개라면 출력
					if (flag) {
						System.out.println(omokpan[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
					// 대각선 위(i가 5 미만이라면 대각선 위롤 탐색하는데 범위를 넘어선다)
					if (i > 4) {
						flag = true;
						for (int k = j, h = i; k < j + 4 && j < omokpan.length
								&& h > 0; k++, h--) {
							if (omokpan[h][k] != omokpan[h - 1][k + 1]) {
								flag = false;
							}
						}
						if (i - 5 > 0
								&& j + 5 < omokpan.length
								&&  omokpan[i - 4][j + 4] == omokpan[i - 5][j + 5]) {
							flag = false;
						}
						if(i<omokpan.length-1 && j>0 && omokpan[i - 4][j + 4] == omokpan[i + 1][j - 1])
						{
							flag = false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					//아래로 향하는 범위를 안넘도록 제한
					if (i < omokpan.length - 4) {
						// 대각선 아래
						flag = true;
						for (int k = j, h = i; k < j + 4 && k < omokpan.length
								&& h < omokpan.length; k++, h++) {
							if (omokpan[h][k] != omokpan[h + 1][k + 1]) {
								flag = false;
							}
						}
						if (i + 5 < omokpan.length
								&& j + 5 < omokpan.length
								&& omokpan[i + 4][j + 4] == omokpan[i + 5][j + 5]) {
							flag = false;
						}
						if(i > 0 && j >0 && omokpan[i + 4][j + 4] == omokpan[i - 1][j - 1]){
							flag =false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
						// 아래
						flag = true;
						for (int k = i; k < i + 4 && k < omokpan.length; k++) {
							if (omokpan[k][j] != omokpan[k + 1][j]) {
								flag = false;
							}
						}
						if (i + 5 < omokpan.length
								&& omokpan[i + 4][j] == omokpan[i + 5][j]) {
							flag = false;
						}
						if(i>0 &&omokpan[i + 4][j] == omokpan[i - 1][j]){
							flag =false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
				}
			}
		}
		//오목 되는게 없는 경우 0 출력
		System.out.println("0");
	}
}
