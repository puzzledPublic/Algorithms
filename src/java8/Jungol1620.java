package java8;

import java.util.Scanner;
//전화번호 속의 암호
//전화번호와 숫자 2개가 주어진다 (전화번호문자열 <= 100, 1<= 더해질 숫자 <= 9, 위치 번호)
//첫번째 숫자는 해당 전화번호 숫자들에 더할 숫자고 
//두번째 숫자는 첫번째 숫자를 더할 전화번호의 위치를 나타낸다
//전화번호는 '-'으로 구분되며 0~9사이 숫자다
//더하는 숫자가 9가 넘을 경우 1의 자리 값을 취한다.
//숫자는 총 4자리여야 하며 4자리가 안될 경우 앞쪽부터 0을 채워 넣는다.
//처리조건이 만족하지 않는다면 "INPUT ERROR"을 출력한다.

public class Jungol1620 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String phoneNumber;
		int plus, index;
		//입력
		phoneNumber = scanner.next();
		plus = scanner.nextInt();
		index = scanner.nextInt();
		//마지막이 '-'로만 끝나면
		if(phoneNumber.endsWith("-")){
			//끝에 '0'을 붙여줌
			phoneNumber =phoneNumber.concat("0");
		}
		// '-'로 구분하여 String 배열을 만듬
		String[] numbers = phoneNumber.split("-");
		lockNumber(numbers, plus, index);
	}

	static void lockNumber(String[] numbers, int plus, int index) {
		//결과를 담을 4자리 배열
		char[] result = new char[4];
		//번호들 중에 5자리가 넘는 것이 있다면 입력 에러
		for(int i = 0 ; i < numbers.length;i++){
			if(numbers[i].length()>4){
				System.out.println("INPUT ERROR!");
				System.exit(0);
			}
		}
		//위치가 전화번호 더미보다 더 큰 경우 입력 에러
		if (numbers.length < index) {
			System.out.println("INPUT ERROR!");
		} else {
			//번호 더미 길이
			int len = numbers[index - 1].length()-1;
			//결과 배열을 거꾸로 돌며
			for (int i = result.length-1; i >= 0; i--) {
				//번호 더미 길이가 바닥났으면
				if (len < 0) {
					//0으로 치고 plus를 더해줌
					result[i] = (char)(plus+48);
				}
				//아니라면
				else {
					//현재 숫자에 plus를 더함
					int temp = ((int) (numbers[index - 1].charAt(len--)) + plus);
					//10을 넘어가면 1의 자리 수만 넣는다
					result[i] = temp>57? (char)(temp-10):(char)temp;
				}
			}
			//결과 배열 출력
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
		}
	}
}
