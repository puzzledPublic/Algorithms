package java8;

import java.util.Arrays;
import java.util.Scanner;

//¶± ¸Ô´Â È£¶ûÀÌ
//
public class Jungol1997 {

	static int fibs[] = new int[100]; 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int day, dduckAmount;
		day = scanner.nextInt();
		dduckAmount = scanner.nextInt();
		Arrays.fill(fibs, 0);
		//
		for (int i = 1; i < dduckAmount; i++) {
			for (int j = i + 1; j < dduckAmount; j++) {
				if (dduckAmount == i * fibo(day - 3) + j * fibo(day - 2)) {
					System.out.println(i + "\n" + j);
					return;
				}
			}
		}
	}
	//ÇÇº¸³ªÄ¡ 
	static int fibo(int n) {
		if (n <= 1) {
			return 1;
		}
		if(fibs[n] !=0){
			return fibs[n];
		}
		return fibs[n]=fibo(n - 1) + fibo(n - 2);
	}
}
