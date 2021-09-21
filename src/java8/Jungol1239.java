package java8;

import java.util.Scanner;

//비밀편지
//A(000000),B(001111),C(010011),D(011100),E(100110),F(101001),G(110101),H(111010)은 암호문이다
//입력- 문자개수(textLength <=10), 문자열( 0 또는 1로 이루어진 (textLength * 6)개의 문자열)이 주어질 때
//해당 문자로 복호화를 하라(문자가 2개 이상 다르다면 해당 위치를 출력, 1개가 다르다면 그대로 문자를 출력)
public class Jungol1239 {
	//해당 암호문 저장
	static char[][] cryptography = { { '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '1', '1', '1', '1' }, { '0', '1', '0', '0', '1', '1' },
			{ '0', '1', '1', '1', '0', '0' }, { '1', '0', '0', '1', '1', '0' },
			{ '1', '0', '1', '0', '0', '1' }, { '1', '1', '0', '1', '0', '1' },
			{ '1', '1', '1', '0', '1', '0' }, };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int textLength;
		String text;
		//입력
		textLength = scanner.nextInt();
		text = scanner.next();
		//실행
		decryptSecretMail(text.toCharArray());

	}

	static void decryptSecretMail(char[] text) {
		
		int min = 9999;
		//복호화한 문자를 담을 배열
		char[] decryptedText = new char[text.length/6];
		//비교할 문자가 몇개나 다른지 측정할 변수 
		int count = 0;
		//암호문과 비교했을때 다른 문자가 2개 이상인경우 증가
		int failCount = 0;
		//모든 문자를 돌며(6개 단위)
		for (int i = 0; i < text.length / 6; i++) {
			//암호문을 돌며
			for (int j = 0; j < cryptography.length; j++) {
				count = 0;
				for (int k = 0; k < cryptography[0].length; k++) {
					//만일 다른 문자가 있는 경우
					if (text[i * 6 + k] != cryptography[j][k]) {
						count++; //증가
					}
				}
				//다른 문자의 개수가 0, 1 이면
				if (count == 0 || count == 1) {
					//문자를 해독 후 다음 문자로 
					decryptedText[i] = (char)(j+65);
					break;
				}
				//2 이상이면 failCount 증가
				else{
					failCount++;
				}
				
			}
			//System.out.println(failCount);
			//만약 failCount가 8인경우(모든 암호문을 탐색해도 매칭되는 문자가 없는 경우)
			if(failCount == 8){
				//해당 위치를 저장 후 전체 for문 종료
				min = i+1;
				break;
			}
			failCount=0;
		}
		//출력
		if(failCount == 8){
			System.out.println(min);
		}
		else{
			for(int i = 0 ; i < decryptedText.length; i++){
				System.out.print(decryptedText[i]);
			}
		}
	}
}
