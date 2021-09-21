package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정수의 개수
public class BJ10821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(",");
		System.out.println(s.length);
	}
}
