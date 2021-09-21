package java8;

import java.util.Arrays;
import java.util.Scanner;

//최대값 KOI 2007 초등부
public class Jungol1035 {
	
	static int numbers[] = new int[9];
	static int sorted[] = new int[9]; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//입력
		for(int i = 0; i < 9; i++){
			sorted[i] = numbers[i] = input.nextInt();
		}
		
		//처리
		Arrays.sort(sorted);
		
		for(int i = 0; i< 9; i++){
			if(sorted[8] == numbers[i]){	//최대값이랑 원래 수열 중에서 숫자가 같다면
				System.out.println(sorted[8]);	//최대값 출력
				System.out.println(i+1);	//최대값 위치 출력
				break;
			}
		}
	}
}
