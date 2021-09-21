package java8;

import java.util.Scanner;
//주어진 숫자의 이진수에서 1 사이의 거리 중 가장 긴 길이를 리턴하라
public class BinaryGap {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		System.out.println(Integer.toBinaryString(number));
		System.out.println(findLongestGap(number));
	}
	static int findLongestGap(int number){
		int result = 0;
		int curr = 0;
		//첫 이진수가 0 인경우 1일때 까지 오른쪽 쉬프트
		while((number & 1) != 1){
			number >>= 1;
		}
		while(number != 0){
			
			if((number & 1) == 1){
				result = Math.max(result, curr);
				curr = 0;
			}
			
			number >>= 1;
			
			curr++;
		}
		//마지막 +1 되는 것을 조정
		return result - 1;
	}
}
