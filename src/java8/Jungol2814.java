package java8;

import java.util.Scanner;

//이진수
//2진수를 입력 받아 10진수로 출력하라
public class Jungol2814 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String bi;
		bi = scanner.nextLine();
		
		biToDecimal(bi);
		biToDecimal2(bi.toCharArray());
	}
	//끝 부터 계산
	static void biToDecimal(String bi) {
		int decimal = 0;
		int m = 1;
		for (int i = bi.length() - 1; i >= 0; i--) {
			if (bi.charAt(i) == '1') {
				decimal += m;
			}
			m *= 2;
		}
		System.out.println(decimal);
	}
	//처음부터 계산
	static void biToDecimal2(char[] bi) {
		int len = bi.length;
		int ten = 0;
		for (int i = 0; i < len; i++) {
			ten = ten * 2 + (bi[i] - '0');
		}
		System.out.println(ten);
	}
}
