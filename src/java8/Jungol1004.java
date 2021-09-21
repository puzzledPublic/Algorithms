package java8;

import java.text.DecimalFormat;
import java.util.Scanner;

//합과 평균 표준편차 
public class Jungol1004 {
	
	static double numbers[];	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//입력
		int N, sum = 0;
		double M, S;
		N = input.nextInt();
		
		numbers = new double[N];
		for(int i = 0 ; i < N; i++){
			numbers[i] = input.nextInt();
			sum += numbers[i];	//입력을 받으며 합계산
		}
		
		M = sum /(double)N;	//평균 결과
		
		System.out.println((int)sum);	//합 먼저 출력
		
		sum = 0;	//표준편차 구하기 위해 sum 초기화
		
		for(int i = 0 ; i < N; i++){
			sum += Math.pow(numbers[i]-M, 2);	//(x - M)^2의 합 계산
		}
		
		S = Math.sqrt(sum / (double)N);	//표준편차 결과
		
		DecimalFormat df = new DecimalFormat("#.#");	//소수 2자리에서 올림과 .0을 지우기 위한 DecimalFormat
		System.out.println(df.format(M));
		System.out.println(df.format(S));
	}
}
