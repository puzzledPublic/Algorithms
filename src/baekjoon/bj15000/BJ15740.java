package baekjoon.bj15000;

import java.math.BigInteger;
import java.util.Scanner;
//A + B -9
public class BJ15740 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger bi = new BigInteger(input.next());
		BigInteger bi2 = new BigInteger(input.next());
		System.out.println(bi.add(bi2));
	}
}
