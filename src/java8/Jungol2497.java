package java8;

import java.util.Scanner;

//수열, KOI 2011 전국 초등부
public class Jungol2497 {
	
	static int temperature[];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number, days, start, end, result = 0, temp;
		
		//입력
		number = input.nextInt();
		days = input.nextInt();
		
		temperature = new int[number];
		
		for(int i = 0; i < number; i++){
			temperature[i] = input.nextInt();
		}
		
		//처리
		for(int i = 0; i < days; i++){	// 처음 days만큼 합 계산
			result += temperature[i];
		}
		
		temp = result;	
		start = 0;	//첫 날 포인터
		end = days;	//마지막 날 포인터
		
		while(end != number){
			temp -= temperature[start++];	 
			temp += temperature[end++];
			result = Math.max(result, temp);
		}
		
		//출력
		System.out.println(result);
	}
}
