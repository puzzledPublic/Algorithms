package java8;

import java.util.Scanner;

//소수369
public class Jungol1011 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int people, num, person;
		people = input.nextInt();
		num = input.nextInt();
		person = input.nextInt();
		//에라토스테네스 체 
		boolean[] erasto = new boolean[num+1];
		erasto[1] = true; 
		for(int i = 2; i * i <= num; i++){
			if(erasto[i] == false){
				for(int j = i+i; j <= num; j+=i){
					erasto[j] = true;
				}
			}
		}
		
		//계산
		int count = 0;
		for(int i = 1+person; i < erasto.length; i+=people){
			if(erasto[i] == false){
				count++;
			}
		}
		System.out.println(count);
		
	}
}
