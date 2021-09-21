package java8;

import java.util.Scanner;

//10진수를 입력받아 2진수로 출력
public class Jungol2815 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int decimal;
		decimal = scanner.nextInt();
		
		decimalToBi(decimal);
		System.out.println();
		decimalToBi3(decimal);
	}
	static void decimalToBi(int decimal){
		int[] arr = new int[100];
		int i=0;
		while(true){
			if(decimal/2 ==0){
				arr[i] = decimal%2;
				break;
			}
			arr[i] = decimal%2;
			decimal /=2;
			i++;
		}
		for(int j = i ; j>=0;j--){
			System.out.print(arr[j]);
		}
	}
	//다른 버전
	static void decimalToBi2(int decimal){
		int[] arr = new int[50];
		int i;
		for(i=0;;i++){
			arr[i]=decimal%2;
			decimal/=2;
			if(decimal==0){
				break;
			}
		}
		for(int j = i; j>=0;j--){
			System.out.print(arr[j]);
		}
	}
	//재귀로 만든 십진수 -> 이진수 변환
	static void decimalToBi3(int decimal){
		if(decimal == 0){
			return;
		}
		decimalToBi3(decimal/2);
		System.out.print(decimal%2);
	}
}
