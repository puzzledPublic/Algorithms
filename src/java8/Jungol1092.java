package java8;

import java.util.Scanner;

//제곱 수 출력
public class Jungol1092 {
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int x, y;
		x = input.nextInt();
		y = input.nextInt();
		if(x == 0 && y == 0){
			System.out.println(1);
		}else{
			System.out.println(solve(x, y));
		}
	}
	
	static long solve(int x, int y){
		if(y == 1){
			return x;
		}
		long ret = 0;
		if(y % 2 == 0){	//짝수인 경우
			ret =  solve(x, y / 2);
			ret *= ret;
		}
		else{	//홀수인 경우
			ret =  solve(x, y / 2 + 1) * solve(x, y / 2);
		}
		return ret % 20091024;
	}
}
