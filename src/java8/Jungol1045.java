package java8;

import java.util.Scanner;

//암스트롱 수, uva 12895

public class Jungol1045 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N;
		N = input.nextInt();
		boolean f = false;
		int temp, result = 0;
		
		for(int i = 100; i <= N; i++){
			temp = i;
			while(temp != 0){
				result += (int)Math.pow(temp%10, 3);
				temp /= 10;
			}
			if(result == i){
				System.out.println(i);
				f = true;
			}
			result = 0;
			
		}
		if(!f){
			System.out.println(0);
		}
	}
}
