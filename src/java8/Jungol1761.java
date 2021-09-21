package java8;

import java.util.Scanner;

//숫자야구
//1~9자리의 3자리의 숫자야구이다.
//물어본 3자리 숫자들과 그에 대한 스트라이크, 볼의 여부에 대한 대답이 입력으로 주어진다.
//이때 가능성 있는 3자리들의 개수를 구하라
//입력: 질문의 개수 N ( 1 <= N <= 100), 다음 N개의 줄에 질문한 3자리수와 그에 따른 스트라이크, 볼의 개수를 나타내는 정수

public class Jungol1761 {
	static boolean[] baseballNumbers = new boolean[1000];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		// 질문한 3자리수를 넣을 배열
		int[] number = new int[n];
		// 질문한 결과에 대한 배열
		int[][] result = new int[n][2];
		// 입력
		for (int i = 0; i < n; i++) {
			number[i] = scanner.nextInt();
			result[i][0] = scanner.nextInt();
			result[i][1] = scanner.nextInt();
		}
		// 질문한 3자리수의 배열을 탐색하며
		for (int i = 0; i < n; i++) {
			// 모든 3자리수를 탐색
			for (int j = 111; j < baseballNumbers.length; j++) {
				// 처음 질문에 대한 가능한 3자리 숫자들을 체크한다
				if (i == 0) {
					if (checkNumber(j, number[i], result[i][0], result[i][1])) {
						baseballNumbers[j] = true;
					}
				}
				// 이후 질문부터는 체크된 것들에서만 걸러낸다
				else {
					if (baseballNumbers[j] == true
							&& !checkNumber(j, number[i], result[i][0],
									result[i][1])) {
						baseballNumbers[j] = false;
					}
				}
			}
		}
		int count = 0;
		for (int i = 111; i < baseballNumbers.length; i++) {
			if (baseballNumbers[i] == true) {
				count++;
			}
		}
		System.out.println(count);

	}
	//스트라이크 인지 볼인지 판별하는 함수
	static boolean checkNumber(int checkNumber, int number, int s, int b) {
		int[] cN = new int[3];
		int[] iN = new int[3];

		for (int i = 2; i >= 0; i--) {
			cN[i] = checkNumber % 10;
			checkNumber /= 10;
			iN[i] = number % 10;
			number /= 10;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (cN[j] == 0 || cN[i] == cN[j]) {
					return false;
				}
			}
		}
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (cN[i] == iN[i]) {
				strike++;
			} else {
				for (int j = 0; j < 3; j++) {
					if (cN[j] == iN[i]) {
						ball++;
					}
				}
			}
		}
		if (strike == s && ball == b) {
			// System.out.println(cN[0]+""+cN[1]+""+cN[2]+" "+iN[0]+""+iN[1]+""+iN[2]
			// +" "+s+" "+b);
			return true;
		}
		return false;

	}
}
