package baekjoon.bj10000;

import java.util.Scanner;
//평균 점수
public class BJ10039 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = 0, t;
		for(int i = 0; i < 5; i++) {
			if((t = input.nextInt()) < 40) {
				sum += 40;
			}else {
				sum += t;
			}
		}
		System.out.println(sum / 5);
		input.close();
	}
}
