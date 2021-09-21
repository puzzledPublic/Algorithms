package baekjoon.bj1000;

import java.util.Scanner;

//영화감독 숌
public class BJ1436 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int start = 665;	//665부터 브루트포스
		while(N > 0) {
			start++;
			if(isCorrect(start)) {	//666이 연속하는지 검사
				N--;
			}
		}
		System.out.println(start);
	}
	static boolean isCorrect(int n) {
		int count = 0;
		while(n > 0) {
			if(n % 10 == 6) {	//뒤에서부터 6인지 검사
				count++;
			}else {	//6이 아니면 횟수 초기화
				count = 0;
			}
			if(count == 3) {	//3번 연속한다면 바로 리턴
				return true;
			}
			n /= 10;
		}
		return false;
	}
}
