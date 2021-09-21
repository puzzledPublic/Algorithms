package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//세 수
public class BJ10817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int[] a = new int[3];
		for(int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		if(a[0] > a[1]) {
			if(a[0] > a[2]) {
				if(a[1] > a[2]) {
					System.out.println(a[1]);
				}else {
					System.out.println(a[2]);
				}
			}else {
				System.out.println(a[0]);
			}
		}else {
			if(a[0] < a[2]) {
				if(a[1] < a[2]) {
					System.out.println(a[1]);
				}else {
					System.out.println(a[2]);
				}
			}else {
				System.out.println(a[0]);
			}
		}
	}
}
