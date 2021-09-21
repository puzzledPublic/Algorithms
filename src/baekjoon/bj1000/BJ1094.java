package baekjoon.bj1000;

import java.util.Scanner;
//막대기
public class BJ1094 {
	static int N, c, count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		int t = 64;	
		while(c != N) {
			if(c + t <= N) {	//그리디하게 선택
				c += t;
				count++;
			}else {
				t /= 2;
			}
		}
		System.out.println(count);
	}	
}
