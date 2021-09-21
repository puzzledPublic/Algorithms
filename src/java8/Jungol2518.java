package java8;

import java.util.Scanner;

//문자열 변환
//입력- 첫줄에는 수정해야하는 정보의 개수 n(n<=50), 
//     다음 n개의 줄에는 각각 2개씩의 문자(첫번째 문자를 두번째 문자로 바꿈), 
//     다음 오타가 포함된 문장의 문자 개수 m( 1<=m<=100000), 
//     다음 m 개의 문자
public class Jungol2518 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;
		n = scanner.nextInt();
		String[][] str = new String[n][2];
		for (int i = 0; i < n; i++) {
			str[i][0] = scanner.next();
			str[i][1] = scanner.next();
		}
		
		m = scanner.nextInt();
		String[] text = new String[m];
		for (int i = 0; i < m; i++) {
			text[i] = scanner.next();
		}
		
		changeText(str, text);
	}
	//입력이 많을 수록 시간이 급격히 증가 O(n^2)
	static void changeText(String[][] str, String[] text) {

		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if(text[i].equals(str[j][0])){
					text[i]=str[j][1];
					break;
				}
			}
		}
		for(int i = 0 ; i < text.length;i++){
			System.out.print(text[i]);
		}
	}
}
