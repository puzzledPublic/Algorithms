package java8;

import java.util.Scanner;

//그릇
// '(' or ')'로만 구성된 문자열이 주어진다
// '(', ')' 하나는 10cm이고 '()' => 20cm, '((' 같은 방향으로 겹쳐졌을때는 +5cm가 된다(15cm)
//쌓인 그릇의 총 길이를 구하라 (문자열 길이: 3 <= text <= 50) 
public class Jungol2604 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		//입력
		text = scanner.nextLine();
		bowlStack(text.toCharArray());
	}
	static void bowlStack(char[] bowl){
		//처음 그릇길이 설정 
		int bowlLength = 10;
		//두번째 그릇부터 마지막 그릇까지
		for(int i = 1 ; i < bowl.length; i++){
			//전 그릇과 같다면 +5cm
			if(bowl[i-1]==bowl[i]){
				bowlLength+=5;
			}
			//다르다면 +10cm
			else{
				bowlLength+=10;
			}
		}
		//출력
		System.out.println(bowlLength);
	}
}
