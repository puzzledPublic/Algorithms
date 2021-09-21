package java8;

import java.util.Scanner;

//비트 삽입
public class CCI_5_1 {
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		
		String result = binaryInsert("10000000000", "10011", 2, 6);
		
		System.out.println(result);
	}
	
	static String binaryInsert(String M, String N, int i, int j) {
		
		int m = Integer.parseInt(M, 2);
		int n = Integer.parseInt(N, 2);
		
		return Integer.toBinaryString((m & ((-1 << (j + 1)) | ((1 << i) - 1))) | (n << i));
	}
}
