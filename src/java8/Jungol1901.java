package java8;

import java.util.Scanner;

//소수 구하기
//임의의 M값에 대해 M에 가장 가까운 소수를 구하라(차이가 같은 수가 여러개면 작은 수 부터 모두 출력)
public class Jungol1901 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		// 처리해야 할 수의 개수(n<=100)
		int n;
		n = scanner.nextInt();
		// 처리할 수의 개수만큼 배열 생성
		int arr[] = new int[n];
		//입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		//출력
		printPNumber(arr);
	}

	static void printPNumber(int[] arr) {
		//현재 숫자로부터 편차
		int defer = 0;
		//편차의 숫자가 소수인지 아닌지 저장하는 변수
		boolean down, up;
		//입력 숫자들을 돌며
		for(int i = 0 ; i < arr.length;i++){
			//만일 자기자신이 소수라면 그대로 출력하고 다음 숫자로
			if(isPrimeNumber(arr[i])){
				System.out.println(arr[i]);
				continue;
			}
			//숫자를 점점 위, 아래로 움직이며
			while(arr[i]-defer>2){
				//아래 숫자가 소수인지 아닌지
				down = isPrimeNumber(arr[i]-defer);
				//위 숫자가 소수인지 아닌지
				up = isPrimeNumber(arr[i]+defer);
				//둘다 소수라면
				if(down && up){
					//작은 수 부터 출력하고 루프 탈출
					System.out.print(arr[i]-defer+" ");
					System.out.println(arr[i]+defer);
					break;
				}
				//아래 숫자만 소수라면 출력하고 루프 탈출
				else if(down){
					System.out.println(arr[i]-defer);
					break;
				}
				//위 숫자만 소수라면 출력하고 루프 탈출
				else if(up){
					System.out.println(arr[i]+defer);
					break;
				}
				//편차를 증가
				defer++;
			}
			//다음 숫자를 위해 편차 초기화
			defer=0;
		}
	}
	//소수인지 아닌지 판별하는 함수
	static boolean isPrimeNumber(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
