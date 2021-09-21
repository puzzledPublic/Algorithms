package java8;

import java.math.BigInteger;
import java.util.Scanner;

//각 자리수의 합
public class Jungol1009 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = false;	// ex) 193200을 그대로 뒤집으면 002391인데 앞 0은 제외시켜야 하므로 0이상 숫자가 나올때까지 출력하지 않기 위한 flag
		int N;
		while((N = input.nextInt()) != 0){
			int temp, sum = 0;
			while(N != 0){
				temp = N % 10;	//맨 뒷자리수
				sum += temp;	//각 자리 수 합
				if(temp > 0){
					flag = true;	//최초 0이상 숫자가 나오면 flag true 
				}
				if(flag){
					System.out.print(temp);
				}
				N /= 10;
			}
			System.out.println(" " + sum);
			flag = false;	//flag 리셋
		}
	}
}
