package java8;

import java.util.Scanner;

//강아지와 병아리, 문제은행
public class Jungol1001 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int legsOfAnimal, amountOfAnimal;	//강아지+병아리의 마리수, 다리수
		int dog, chick;	//강아지, 병아리 마리수
		
		//입력
		amountOfAnimal = input.nextInt();
		legsOfAnimal = input.nextInt();
		
		//처리
		while(amountOfAnimal != 0 && legsOfAnimal != 0){
			if(amountOfAnimal < 0 || amountOfAnimal > 1000 || legsOfAnimal < 0 || legsOfAnimal > 4000){	//입력 값을 넘어가는 경우
				System.out.println("INPUT ERROR!");
			}else{
				// (2(병아리 마리수) * 총 마리수) <= 총 다리수 <= (4(강아지 다리수) * 총 마리수) 그리고 총 다리수는 2의 배수여야 마리 수를 정할 수 있다.
				if((2 * amountOfAnimal) <= legsOfAnimal && (4 * amountOfAnimal) >= legsOfAnimal && legsOfAnimal % 2 == 0){	
					dog = (legsOfAnimal - (2 * amountOfAnimal))/2;	//dog * chick = amountOfAnimal 
					chick = amountOfAnimal - dog;					//4 * dog + 2 * chick = legsOfAnimal을 연립하여 품
					System.out.println(dog + " " + chick);			//강아지, 병아리 마리 수 결과 출력
				}else{
					System.out.println(0);	//마리 수를 정할 수 없는 경우 0 출력
				}
			}
			amountOfAnimal = input.nextInt();
			legsOfAnimal = input.nextInt();
		}
	}
}
