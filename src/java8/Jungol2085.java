package java8;

import java.util.Scanner;

//윤년(년도 사이의 윤년의 개수를 구하라)
//startYear = 시작년도, endYear = 마지막년도
//startYear + 1 ~ endYear까지의 윤년의 개수는?
//윤년은 4로 나눠지고 100으로 나눠지지 않거나 400으로 나눠지는 년도를 말한다.
public class Jungol2085 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int startYear, endYear;
		endYear = scanner.nextInt();
		startYear = scanner.nextInt();

		leapYear(startYear, endYear);
	}

	static void leapYear(int startYear, int endYear) {
		int count = 0;
		int fixedYear = 0;
		//윤년은 홀수가 없고 기본적으로 4의 배수이므로 startYear를 4의 배수로 바꿔준다 => fixedYear
		fixedYear = startYear+(4-startYear%4);
		//startYear + 1부터 fixedYear까지의 윤년을 구한다
		for (int i = startYear+1; i < fixedYear; i++) {
			if ( i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
				count++;
			}
		}
		//fixedYear부터 endYear까지 4의배수인 년도만을 돌며 윤년을 구한다
		for (int i = fixedYear; i <= endYear; i+=4) {
			if ( i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
				count++;
			}
		}
		//윤년 개수 출력
		System.out.println(count);
	}
}
