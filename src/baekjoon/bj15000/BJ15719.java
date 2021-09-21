package baekjoon.bj15000;

import java.io.IOException;
import java.util.Scanner;

//중복된 숫자	//1000만개 숫자를 한번에 메모리에 담으면 메모리 초과남..
//2018.12.08 재채점으로 scanner로도 메모리 초과
public class BJ15719 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		long N = input.nextLong();
		long t = 0, s = 0;
		s = (N - 1) * N / 2;
		for(int i = 0; i < N; i++) {
			t += input.nextLong();
		}
		System.out.println(t - s);
	}
}
