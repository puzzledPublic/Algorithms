package java8;

import java.util.Scanner;

/*소수와 합성수
 소수: 1보다 큰 자연수 중 1과 자기 자신, 두 개만을 약수로 갖는 수
 합성수: 1보다 큰 자연수 중 소수가 아닌 수, 3개 이상의 약수를 갖는 수
 1은 소수도 합성수도 아니다.
 10억 이하인 5개의 수를 입력 받아 소수, 합성수, 1 인지 판별하라
 */
public class Jungol2811 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		//입력 받을 숫자 배열
		int[] number = new int[5];

		//입력
		for (int i = 0; i < 5; i++) {
			number[i] = scanner.nextInt();
		}
		//숫자들을 돌며
		for (int i = 0; i < 5; i++) {
			//숫자가 1 이면 그대로 출력 후 다음 숫자로
			if (number[i] == 1) {
				System.out.println("number one");
				continue;
			}
			//소수라면 출력
			else if (isPrimeNumber(number[i])) {
				System.out.println("prime number");
			}
			//아무것도 아니라면 합성수 출력
			else {
				System.out.println("composite number");
			}
		}
	}
	//소수인지 아닌지 판별하는 함수
	static boolean isPrimeNumber(int n) {
		
		for(int i = 2; i*i<=n;i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}
