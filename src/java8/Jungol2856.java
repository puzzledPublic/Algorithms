package java8;

import java.util.Scanner;

//10부제 KOI 초등부
public class Jungol2856 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Day = input.nextInt();
		int count = 0;
		for(int i = 0 ; i < 5; i++){
			if(Day == input.nextInt()){
				count++;
			}
		}
		System.out.println(count);
		
	}
}
