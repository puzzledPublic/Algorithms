package baekjoon.bj1000;

import java.util.Scanner;

//토너먼트
public class BJ1057 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		int k = input.nextInt();
		int i = input.nextInt();
		int count = 0;
		while(k != i) {	//k와 i가 번호가 같은 순간 붙는다!
			k = nextNum(k);
			i = nextNum(i);
			count++;
		}
		System.out.println(count);
	}
	static int nextNum(int n) {	//번호가 짝수면 다음 라운드 진출시 n / 2번을 받고 홀수면 n / 2 + 1번을 받는다.
		return n % 2 == 0 ? n / 2 : n / 2 + 1;
	}
}
