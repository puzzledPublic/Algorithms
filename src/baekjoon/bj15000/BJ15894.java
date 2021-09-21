package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수학은 체육과목입니다.
public class BJ15894 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		System.out.println(4 * N);
	}
}
