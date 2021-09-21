package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//열개씩 끊어 출력하기
public class BJ11721 {
	public static void main(String args[]) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 0;
		String s = br.readLine();
		while(a < s.length()) {
			System.out.println(s.substring(a, a + 10 > s.length() ? s.length() : a + 10));
			a += 10;
		}
	}
}
