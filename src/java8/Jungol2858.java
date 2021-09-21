package java8;

import java.util.Scanner;

//쇠막대기 KOI 2015 초등부/중등부
public class Jungol2858 {
	static char arr[]; //쇠막대기 괄호를 받을 배열
	static int top = 0; //이어지는 쇠막대기 개수
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] arr = input.next().toCharArray();
		int stickCount = 0; //잘린 쇠막대기 개수
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] == '(' && arr[i+1] == ')'){ //레이저인 경우
				stickCount += top; //현재 이어지는 쇠막대기 개수 만큼 증가
				i++; // ')'하나 더 뛰어 넘어야 하므로
				continue;
			}
			if(arr[i] == '('){ //막대기가 추가 되는 경우
				top++;
			}else{ //막대기가 끝나는 경우
				stickCount += 1; //끝난 막대기 1개 추가
				top--;
			}
		}
		System.out.println(stickCount); //결과 출력
	}
}
