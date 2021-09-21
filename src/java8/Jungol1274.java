package java8;

import java.util.Scanner;

//2진수를 10진수로...
//2진수를 입력받아 10진수로 바꿔라
//입력받는 2진수는 8비트로 구성되며 최상위 비트는 부호비트
//0이면 양수 1이면 음수이며 음수는 2의 보수
public class Jungol1274 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String bi;
		bi = scanner.nextLine();
		change(bi.toCharArray());
	}

	static void change(char[] bi) {
		int result;
		//양수일때
		if (bi[0] == '0') {
			//그대로 십진수로 변경
			result = biToDecimal(bi);
		}
		//음수일때
		else {
			//1의 보수로 바꿈
			for (int i = 1; i < bi.length; i++) {
				if (bi[i] == '0') {
					bi[i] = '1';
				} else {
					bi[i] = '0';
				}
			}
			//비트에 1을 더함
			if (bi[bi.length - 1] == '0') {
				bi[bi.length - 1] = '1';
			} else {
				bi[bi.length-1] = '0';
				for (int j = bi.length - 2; j > 0; j--) {
					if (bi[j] == '0') {
						bi[j] = '1';
						break;
					}
					else{
						bi[j] = '0';
					}
				}
			}
			//십진수로 변환
			result = biToDecimal(bi);
			//부호 설정
			result *=-1;
		}
		//결과 출력
		System.out.println(result);
	}
	//2진수 -> 10진수 변환 함수
	static int biToDecimal(char[] bi){
		int ten = 0;
		for (int i = 1; i < bi.length; i++) {
			ten = ten * 2 + (bi[i] - '0');
		}
		return ten;
	}
}
